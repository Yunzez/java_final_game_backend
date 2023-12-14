package com.example.final_backend;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.final_backend.exception.DocumentNotFoundException;
import com.example.final_backend.exception.ErrorResponse;
import com.example.final_backend.exception.PasswordNotMatchException;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<Object> handleDocumentNotFoundException(DocumentNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Object> handleDuplicateKeyException(DuplicateKeyException e) {
        ErrorResponse errorResponse = new ErrorResponse(Arrays.asList("Username already exists"));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<Object> handlePassswordNotMatch(PasswordNotMatchException e) {
        ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> errors.add(error.getDefaultMessage()));
        return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
    }
}
