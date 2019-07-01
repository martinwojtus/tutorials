package com.frontbackend.thymeleaf.snippets.service;

import com.frontbackend.thymeleaf.snippets.model.Snippet;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SnippetService {

    public List<Snippet> getAllSnippets() {
        return Arrays.asList(Snippet.builder()
                                    .code("alert('test');")
                                    .language("javascript")
                                    .published(true)
                                    .title("Alert with Test")
                                    .author("John")
                                    .build(),
                Snippet.builder()
                       .code("public abstract class Test { }")
                       .language("java")
                       .published(false)
                       .title("Java class example")
                       .author("Alice")
                       .build());
    }

}
