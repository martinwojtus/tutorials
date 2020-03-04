package com.frontbackend.thymeleaf.bootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frontbackend.thymeleaf.bootstrap.model.Colors;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    @GetMapping
    public String main(Model model) {
        Colors colors = new Colors();
        colors.setHex("#AD9597");
        model.addAttribute("colors", colors);
        return "index";
    }

    @PostMapping
    public String save(Colors colors, Model model) {
        model.addAttribute("colors", colors);
        return "saved";
    }
}