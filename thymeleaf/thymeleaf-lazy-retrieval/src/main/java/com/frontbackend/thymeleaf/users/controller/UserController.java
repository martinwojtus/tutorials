package com.frontbackend.thymeleaf.users.controller;

import com.frontbackend.thymeleaf.users.model.User;
import com.frontbackend.thymeleaf.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.LazyContextVariable;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public String main(Model model) {

        model.addAttribute("users", new LazyContextVariable<List<User>>() {
            @Override
            protected List<User> loadValue() {
                return userService.getUsers();
            }
        });

        return "users";
    }
}
