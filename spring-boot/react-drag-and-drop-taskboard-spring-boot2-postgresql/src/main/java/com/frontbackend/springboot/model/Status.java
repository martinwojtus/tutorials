package com.frontbackend.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {

    @JsonProperty("To Do")
    TODO("To Do"),

    @JsonProperty("In Progress")
    IN_PROGRESS("In Progress"),

    @JsonProperty("Done")
    DONE("Done");

    private final String title;

    Status(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
