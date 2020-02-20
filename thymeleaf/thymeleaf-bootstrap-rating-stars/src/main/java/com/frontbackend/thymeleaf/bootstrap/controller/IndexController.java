package com.frontbackend.thymeleaf.bootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frontbackend.thymeleaf.bootstrap.model.Rating;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    @GetMapping
    public String main(Model model) {
        model.addAttribute("rating", new Rating());
        return "index";
    }

    @PostMapping
    public String save(Rating rating, Model model) {
        model.addAttribute("rating", rating);
        return "saved";
    }
}