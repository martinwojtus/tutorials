package com.frontbackend.thymeleaf.controller;

import com.frontbackend.thymeleaf.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactsController {

    private final ContactService contactService;

    @Autowired
    public ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("contacts")
    public String contacts(Model model) {
        model.addAttribute("contacts", contactService.getContactList());
        return "contacts";
    }
}
