package com.frontbackend.thymeleaf.bootstrap.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BooleanNode {

    private Boolean value;
    private String label;

    private List<BooleanNode> children;
}
