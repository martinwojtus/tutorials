package com.frontbackend.springboot.person.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonFilter {
    private String firstName;
    private String lastName;
    private List<Integer> age;
    private String address;
}
