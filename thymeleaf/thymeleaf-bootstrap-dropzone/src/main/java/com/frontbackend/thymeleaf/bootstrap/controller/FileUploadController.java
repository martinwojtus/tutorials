package com.frontbackend.thymeleaf.bootstrap.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @PostMapping
    public void upload(@RequestParam("file") MultipartFile file) {
        log.info("uploaded file " + file.getOriginalFilename());
    }
}