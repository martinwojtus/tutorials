package com.frontbackend.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Snippet {

    @Id
    private String id;

    private String code;

    @Indexed
    private String language;

    public Snippet(String code, String language) {
        this.code = code;
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Snippet{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
