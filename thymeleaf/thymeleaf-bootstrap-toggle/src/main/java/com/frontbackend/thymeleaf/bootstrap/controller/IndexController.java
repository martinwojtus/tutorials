package com.frontbackend.thymeleaf.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frontbackend.thymeleaf.bootstrap.model.Settings;
import com.frontbackend.thymeleaf.bootstrap.service.SettingsService;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    private final SettingsService settingsService;

    @Autowired
    public IndexController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("settings", settingsService.defaultUserProfileSettings());
        return "index";
    }

    @PostMapping
    public String save(Settings settings, Model model) {
        model.addAttribute("settings", settings);
        return "saved";
    }
}
