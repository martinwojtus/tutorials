package com.frontbackend.springboot.person.controller.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CreatePersonRequest {
    private String firstName;
    private String lastName;
    private int age;
    private String address;
}
