package com.example.final_backend;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.final_backend.exception.DocumentNotFoundException;
import com.example.final_backend.exception.ErrorResponse;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<Object> handleDocumentNotFoundException(DocumentNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
