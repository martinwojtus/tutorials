package com.frontbackend.libraries.apachepoi.model;

import com.frontbackend.libraries.apachepoi.parser.XLSXField;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Post {

    @XLSXField(column = "Title")
    private String title;

    @XLSXField(column = "Content")
    private String content;

    @XLSXField(column = "URL")
    private String url;

}
