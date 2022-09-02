package com.frontbackend.springboot.person.controller.model.request;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class EditPersonRequest {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
}
