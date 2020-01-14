package com.frontbackend.thymeleaf.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frontbackend.thymeleaf.bootstrap.model.PriceRange;
import com.frontbackend.thymeleaf.bootstrap.service.ProductService;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    private final ProductService productService;

    @Autowired
    public IndexController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("priceRange", new PriceRange(5, 100));
        model.addAttribute("products", productService.getMockedProducts());
        return "index";
    }

    @PostMapping
    public String save(PriceRange priceRange, Model model) {
        model.addAttribute("range", priceRange);
        return "saved";
    }
}