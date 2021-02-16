package com.frontbackend.springboot.controller;

import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/pdf")
public class PDFController {

    @Value("${pdf.path}")
    private String pdfFilesPath;

    @GetMapping("{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws IOException {
        Resource resource = new UrlResource(Paths.get(pdfFilesPath)
                                                 .resolve(filename)
                                                 .toUri());

        if (resource.exists() || resource.isReadable()) {
            String contentDisposition = String.format("inline; filename=\"%s\"", resource.getFile()
                                                                                         .getName());
            return ResponseEntity.ok()
                                 .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                                 .body(resource);
        }

        return ResponseEntity.notFound()
                             .build();
    }
}
