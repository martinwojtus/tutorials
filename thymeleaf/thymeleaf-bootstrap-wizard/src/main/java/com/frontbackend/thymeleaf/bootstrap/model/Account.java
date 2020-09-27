package com.frontbackend.thymeleaf.bootstrap.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Account {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String address;
    private Integer age;
    private boolean termsAccepted;
}
