package com.frontbackend.thymeleaf.enums.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class Home {

    private String title;
    private Planet planet;

}
