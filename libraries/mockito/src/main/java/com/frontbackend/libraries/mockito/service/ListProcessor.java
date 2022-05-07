package com.frontbackend.libraries.mockito.service;

import java.util.List;
import java.util.stream.Collectors;

public class ListProcessor {

    public List<String> processList(List<String> list) {
        return list.stream()
                .map(str -> String.format("%s:processed", str))
                .collect(Collectors.toList());
    }
}
