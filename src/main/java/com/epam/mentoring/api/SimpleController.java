package com.epam.mentoring.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value = "/api/v1")
public class SimpleController {

    @GetMapping(value = "/info")
    @ResponseBody
    public String getInfo() {
        return "MVC application";
    }
}
