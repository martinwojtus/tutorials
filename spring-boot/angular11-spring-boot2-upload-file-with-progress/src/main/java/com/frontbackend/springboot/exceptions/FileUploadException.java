package com.frontbackend.springboot.exceptions;

public class FileUploadException extends RuntimeException {

    public FileUploadException(String msg) {
        super(msg);
    }
}
