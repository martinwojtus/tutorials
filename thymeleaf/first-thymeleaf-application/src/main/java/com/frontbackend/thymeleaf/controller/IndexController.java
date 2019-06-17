package com.frontbackend.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({ "/", "/index" })
    public String main(Model model) {
        model.addAttribute("name", "John");

        return "index"; // name of the View
    }
}
