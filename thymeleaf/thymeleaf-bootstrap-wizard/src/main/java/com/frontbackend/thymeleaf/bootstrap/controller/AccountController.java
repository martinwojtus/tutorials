package com.frontbackend.thymeleaf.bootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frontbackend.thymeleaf.bootstrap.model.Account;

@Controller
@RequestMapping("/account")
public class AccountController {

    @PostMapping
    public String submit(Account account, Model model) {
        model.addAttribute("account", account);
        return "saved";
    }
}
