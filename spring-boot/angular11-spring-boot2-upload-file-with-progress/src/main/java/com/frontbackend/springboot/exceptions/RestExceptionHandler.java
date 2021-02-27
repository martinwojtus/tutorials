package com.frontbackend.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.frontbackend.springboot.model.UploadResponseMessage;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<UploadResponseMessage> handleMaxSizeException(MultipartException exc) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                             .body(new UploadResponseMessage("Unable to upload. File is too large!"));
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<UploadResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                             .body(new UploadResponseMessage("Unable to upload. File is too large!"));
    }

    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<UploadResponseMessage> handleMaxSizeException(FileUploadException exc) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(new UploadResponseMessage(exc.getMessage()));
    }
}
