package com.frontbackend.thymeleaf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @GetMapping
    public String main(Model model) throws ParseException {
        model.addAttribute("exampleDate", sdf.parse("20/06/2020"));
        return "index";
    }
}
