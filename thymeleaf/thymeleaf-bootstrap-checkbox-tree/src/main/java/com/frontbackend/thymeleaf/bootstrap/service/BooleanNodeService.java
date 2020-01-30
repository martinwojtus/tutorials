package com.frontbackend.thymeleaf.bootstrap.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.frontbackend.thymeleaf.bootstrap.model.BooleanNode;

@Service
public class BooleanNodeService {

    public BooleanNode buildTree() {
        BooleanNode root = new BooleanNode();

        List<BooleanNode> children = new ArrayList<>();

        children.add(BooleanNode.builder()
                                .label("Checkbox1")
                                .value(false)
                                .children(Arrays.asList(BooleanNode.builder()
                                                                   .value(false)
                                                                   .label("Checkboxa1")
                                                                   .build(),
                                        BooleanNode.builder()
                                                   .value(false)
                                                   .label("Checkboxb1")
                                                   .build(),
                                        BooleanNode.builder()
                                                   .value(false)
                                                   .label("Checkboxc1")
                                                   .build()))
                                .build());

        children.add(BooleanNode.builder()
                                .label("Checkbox2")
                                .value(false)
                                .children(Arrays.asList(BooleanNode.builder()
                                                                   .value(false)
                                                                   .label("Checkboxa2")
                                                                   .build(),
                                        BooleanNode.builder()
                                                   .value(false)
                                                   .label("Checkboxb2")
                                                   .build(),
                                        BooleanNode.builder()
                                                   .value(false)
                                                   .label("Checkboxc2")
                                                   .build()))
                                .build());

        children.add(BooleanNode.builder()
                                .label("Checkbox3")
                                .value(false)
                                .children(Arrays.asList(BooleanNode.builder()
                                                                   .value(false)
                                                                   .label("Checkboxa3")
                                                                   .build(),
                                        BooleanNode.builder()
                                                   .value(false)
                                                   .label("Checkboxb3")
                                                   .build(),
                                        BooleanNode.builder()
                                                   .value(false)
                                                   .label("Checkboxc3")
                                                   .children(Arrays.asList(BooleanNode.builder()
                                                                                      .label("Checkbox31")
                                                                                      .value(false)
                                                                                      .build(),
                                                           BooleanNode.builder()
                                                                      .label("Checkbox32")
                                                                      .value(false)
                                                                      .build(),
                                                           BooleanNode.builder()
                                                                      .label("Checkbox33")
                                                                      .value(false)
                                                                      .build()))
                                                   .build()))
                                .build());

        root.setChildren(children);

        return root;
    }
}
