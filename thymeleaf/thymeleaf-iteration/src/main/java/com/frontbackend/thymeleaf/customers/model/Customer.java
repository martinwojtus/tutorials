package com.frontbackend.thymeleaf.customers.model;

import java.util.List;

import lombok.Data;

@Data
public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private List<Address> addressList;

}
