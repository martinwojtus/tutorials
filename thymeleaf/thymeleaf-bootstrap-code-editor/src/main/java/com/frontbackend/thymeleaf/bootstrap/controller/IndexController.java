package com.frontbackend.thymeleaf.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frontbackend.thymeleaf.bootstrap.model.Snippet;
import com.frontbackend.thymeleaf.bootstrap.util.MimeToLang;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    private final MimeToLang mimeToLang;

    @Autowired
    public IndexController(MimeToLang mimeToLang) {
        this.mimeToLang = mimeToLang;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("snippet", new Snippet());
        return "index";
    }

    @PostMapping
    public String save(Snippet snippet, Model model) {
        snippet.setLang("language-" + mimeToLang.getLangByMime(snippet.getMime()));
        model.addAttribute("snippet", snippet);
        return "saved";
    }
}