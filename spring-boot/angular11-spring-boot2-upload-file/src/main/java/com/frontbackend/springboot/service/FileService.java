package com.frontbackend.springboot.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.frontbackend.springboot.exceptions.FileUploadException;

@Service
public class FileService {

    @Value("${upload.path}")
    private String uploadPath;

    public void save(MultipartFile file) throws FileUploadException {
        try {
            Path root = Paths.get(uploadPath);
            Path resolve = root.resolve(file.getOriginalFilename());
            if (resolve.toFile()
                       .exists()) {
                throw new FileUploadException("File already exists: " + file.getOriginalFilename());
            }
            Files.copy(file.getInputStream(), resolve);
        } catch (Exception e) {
            throw new FileUploadException("Could not store the file. Error: " + e.getMessage());
        }
    }
}
