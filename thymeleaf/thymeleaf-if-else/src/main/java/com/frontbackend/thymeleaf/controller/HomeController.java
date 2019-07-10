package com.frontbackend.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "/", "/home" })
    public String main(Model model) {
        model.addAttribute("condition1IsTrue", Boolean.TRUE);
        model.addAttribute("condition2IsFalse", Boolean.FALSE);

        return "ifelse";
    }
}