package com.frontbackend.thymeleaf.posts.model;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Post {
    private int id;
    private String title;
    private Date date;
}
