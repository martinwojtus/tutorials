package com.frontbackend.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.frontbackend.springboot.model.UploadResponseMessage;
import com.frontbackend.springboot.service.FileService;

@RestController
@RequestMapping("files")
public class FilesController {

    private final FileService fileService;

    @Autowired
    public FilesController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<UploadResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        fileService.save(file);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(new UploadResponseMessage("Uploaded the file successfully: " + file.getOriginalFilename()));
    }
}
