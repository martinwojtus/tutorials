package com.frontbackend.thymeleaf.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frontbackend.thymeleaf.bootstrap.model.BooleanNode;
import com.frontbackend.thymeleaf.bootstrap.service.BooleanNodeService;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    private final BooleanNodeService booleanNodeService;

    @Autowired
    public IndexController(BooleanNodeService booleanNodeService) {
        this.booleanNodeService = booleanNodeService;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("root", booleanNodeService.buildTree());
        return "index";
    }

    @PostMapping
    public String save(BooleanNode root, Model model) {
        model.addAttribute("root", root);
        return "saved";
    }
}