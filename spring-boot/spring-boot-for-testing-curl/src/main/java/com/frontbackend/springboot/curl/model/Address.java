package com.frontbackend.springboot.curl.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Address {

    private String city;
    private String street;
    private String country;
    private String state;
}
