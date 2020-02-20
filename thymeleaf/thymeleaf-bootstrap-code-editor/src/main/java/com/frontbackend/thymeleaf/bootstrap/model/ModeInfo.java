package com.frontbackend.thymeleaf.bootstrap.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ModeInfo {

    private String name;
    private String mode;
    private List<String> mimes;
    private String mime;
    private List<String> ext;
    private List<String> alias;
}
