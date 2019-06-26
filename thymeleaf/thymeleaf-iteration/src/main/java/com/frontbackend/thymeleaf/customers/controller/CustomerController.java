package com.frontbackend.thymeleaf.customers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.frontbackend.thymeleaf.customers.service.CustomerService;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers")
    public String main(Model model) {
        model.addAttribute("customers", customerService.mockCustomers());

        return "customers";
    }
}
