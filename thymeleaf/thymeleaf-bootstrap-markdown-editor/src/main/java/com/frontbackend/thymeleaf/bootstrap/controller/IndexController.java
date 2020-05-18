package com.frontbackend.thymeleaf.bootstrap.controller;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frontbackend.thymeleaf.bootstrap.model.Post;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    @GetMapping
    public String main(Model model) {
        model.addAttribute("post", new Post());
        return "index";
    }

    @PostMapping
    public String save(Post post, Model model) {
        post.setHtml(markdownToHTML(post.getContent()));
        model.addAttribute("post", post);
        return "saved";
    }

    private String markdownToHTML(String markdown) {
        Parser parser = Parser.builder()
                              .build();

        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder()
                                            .build();

        return renderer.render(document);
    }
}