package com.frontbackend.thymeleaf.enums.controller;

import com.frontbackend.thymeleaf.enums.model.Birthplace;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CountryController {

    @PostMapping("/selectedCountry")
    public String selected(Birthplace birthplace, Model model) {
        model.addAttribute("birthplace", birthplace);
        return "selectedCountry";
    }

    @GetMapping("/countries")
    public String countries(Model model) {
        model.addAttribute("birthplace", new Birthplace());
        return "countries";
    }
}
