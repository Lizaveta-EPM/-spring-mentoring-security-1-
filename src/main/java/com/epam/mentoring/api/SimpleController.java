package com.epam.mentoring.api;

import com.epam.mentoring.entity.UserEntity;
import com.epam.mentoring.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/info")
    @ResponseBody
    public String getInfo() {
        return "MVC application";
    }

    @GetMapping(value = "/about")
    @ResponseBody
    public String getAbout() {
        return "This information is available for everyone";
    }

    @GetMapping(value = "/admin")
    @ResponseBody
    public String getAdminInfo() {
        return "This information is for admin";
    }

    @GetMapping(value = "/blocked")
    @ResponseBody
    public List<String> getBlocked() {
        return userRepository.findByEnabled(false).stream()
            .map(UserEntity::getUsername)
            .collect(Collectors.toList());
    }
}
