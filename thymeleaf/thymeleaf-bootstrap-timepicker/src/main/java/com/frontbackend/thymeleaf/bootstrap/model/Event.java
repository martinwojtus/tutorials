package com.frontbackend.thymeleaf.bootstrap.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Event {

    private String title;
    private String description;
    private String time;

}
