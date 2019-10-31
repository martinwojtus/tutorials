package com.frontbackend.thymeleaf.enums.controller;

import com.frontbackend.thymeleaf.enums.model.Home;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SolarSystemController {

    @PostMapping("/selectedPlanet")
    public String saveHome(Home home, Model model) {
        model.addAttribute("home", home);
        return "selectedPlanet";
    }

    @GetMapping("/")
    public String solarSystem(Model model) {
        model.addAttribute("home", new Home());
        return "solarSystem";
    }
}
