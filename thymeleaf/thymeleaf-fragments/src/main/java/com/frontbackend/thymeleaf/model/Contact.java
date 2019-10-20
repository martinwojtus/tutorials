package com.frontbackend.thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class Contact {

    private String name;
    private String email;
    private ContactType type;
    private List<Contact> members;
}
