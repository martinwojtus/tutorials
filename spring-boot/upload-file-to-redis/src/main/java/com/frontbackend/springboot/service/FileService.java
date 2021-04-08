package com.frontbackend.springboot.service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.frontbackend.springboot.model.FileEntity;
import com.frontbackend.springboot.repository.FileRepository;

@Service
public class FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public FileEntity save(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setId(UUID.randomUUID().toString());
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        return fileRepository.save(fileEntity);
    }

    public Optional<FileEntity> getFile(String id) {
        return fileRepository.findById(id);
    }
}
