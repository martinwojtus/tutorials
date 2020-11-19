package com.frontbackend.libraries.mockito.model;

public class Post {
    private final String title;
    private final String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
