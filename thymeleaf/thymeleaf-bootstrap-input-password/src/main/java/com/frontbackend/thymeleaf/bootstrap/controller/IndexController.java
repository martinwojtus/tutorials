package com.frontbackend.thymeleaf.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frontbackend.thymeleaf.bootstrap.model.User;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public IndexController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping
    public String save(User user, Model model) {
        if (!StringUtils.isEmpty(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        model.addAttribute("user", user);
        return "saved";
    }
}
