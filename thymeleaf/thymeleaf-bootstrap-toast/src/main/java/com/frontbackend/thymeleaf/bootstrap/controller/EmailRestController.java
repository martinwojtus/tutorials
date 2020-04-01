package com.frontbackend.thymeleaf.bootstrap.controller;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frontbackend.thymeleaf.bootstrap.model.EmailContainer;

@RestController
@RequestMapping("email")
public class EmailRestController {

    @PostMapping
    public ResponseEntity<String> validateEmail(EmailContainer emailContainer) {
        String email = emailContainer.getEmail();
        boolean valid = EmailValidator.getInstance()
                                      .isValid(email);
        return valid ? ResponseEntity.ok(email) : ResponseEntity.badRequest()
                                                                .body(email);
    }
}
