package com.frontbackend.springboot.curl.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Customer {

    private String firstName;
    private String lastName;
    private List<Address> addressList;
}
