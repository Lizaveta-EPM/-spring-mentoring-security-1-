package com.epam.mentoring.api;

import com.epam.mentoring.entity.Secret;
import com.epam.mentoring.model.SecretForm;
import com.epam.mentoring.service.SecretService;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller(value = "/secrets")
@RequiredArgsConstructor
public class SecretController {

    private final SecretService secretService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("secretForm", new SecretForm());
        return "index";
    }

    @PostMapping("/submit")
    public String create(Model model, @ModelAttribute(name = "secretForm") SecretForm secretForm) {
        String link = UUID.randomUUID().toString();
        secretService.create(new Secret(secretForm.getContent(), link, new Date()));
        model.addAttribute("link", link);
        return "result";
    }

    @GetMapping("/{link}")
    public String getSecret(Model model, @PathVariable String link) {
        Optional<Secret> secret = secretService.findByLink(link);
        secret.ifPresentOrElse(data -> model.addAttribute("secret", data),
            () -> model.addAttribute("404"));

        return "secret";
    }
}
