package com.frontbackend.springboot.person.dto;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PersonDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
}
