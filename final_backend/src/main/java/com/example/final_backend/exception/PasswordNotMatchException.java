package com.example.final_backend.exception;

public class PasswordNotMatchException extends RuntimeException{

    public PasswordNotMatchException(String message) {
        super(message);
    }
}
