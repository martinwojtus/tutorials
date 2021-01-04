package com.frontbackend.springboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.frontbackend.springboot.model.FileData;
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
        try {
            fileService.save(file);

            return ResponseEntity.status(HttpStatus.OK)
                                 .body(new UploadResponseMessage("Uploaded the file successfully: " + file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                                 .body(new UploadResponseMessage("Could not upload the file: " + file.getOriginalFilename() + "!"));
        }
    }

    @GetMapping
    public ResponseEntity<List<FileData>> getListFiles() {
        List<FileData> fileInfos = fileService.loadAll()
                                              .stream()
                                              .map(this::pathToFileData)
                                              .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                             .body(fileInfos);
    }

    @DeleteMapping
    public void delete() {
        fileService.deleteAll();
    }

    private FileData pathToFileData(Path path) {
        FileData fileData = new FileData();
        String filename = path.getFileName()
                              .toString();
        fileData.setFilename(filename);
        fileData.setUrl(MvcUriComponentsBuilder.fromMethodName(FilesController.class, "getFile", filename)
                                               .build()
                                               .toString());
        try {
            fileData.setSize(Files.size(path));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error: " + e.getMessage());
        }

        return fileData;
    }

    @GetMapping("{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fileService.load(filename);
        return ResponseEntity.ok()
                             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                             .body(file);
    }
}
