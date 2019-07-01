package com.frontbackend.thymeleaf.snippets.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Snippet {

    private String title;
    private String code;
    private String language;
    private boolean published;
    private String author;
}
