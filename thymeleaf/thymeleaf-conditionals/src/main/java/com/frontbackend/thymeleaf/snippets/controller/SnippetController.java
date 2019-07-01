package com.frontbackend.thymeleaf.snippets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.frontbackend.thymeleaf.snippets.service.SnippetService;

@Controller
public class SnippetController {

    private final SnippetService snippetService;

    @Autowired
    public SnippetController(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    @GetMapping("snippets")
    public String snippets(Model model) {

        model.addAttribute("snippets", snippetService.getAllSnippets());

        return "snippets";
    }
}
