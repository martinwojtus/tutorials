package com.frontbackend.springboot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @GetMapping("/")
    public String getResourceFile() throws IOException {
        File file = ResourceUtils.getFile("classpath:example.txt");
        System.out.println("File Found : " + file.exists());
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
