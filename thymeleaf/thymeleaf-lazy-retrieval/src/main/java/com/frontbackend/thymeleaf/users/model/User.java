package com.frontbackend.thymeleaf.users.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class User {

    private String username;
    private String email;
}
