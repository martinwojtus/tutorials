package com.frontbackend.thymeleaf.customers.model;

import lombok.Data;

@Data
public class Address {

    private String street;
    private String city;
    private String zip;
    private String state;

}
