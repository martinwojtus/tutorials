package com.frontbackend.thymeleaf.bootstrap.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Input {

    private String time12h;
    private String time24h;
    private String email;
    private String creditCardNumber;
    private String currency;
    private String ipAddress;
    private String decimal;
}
