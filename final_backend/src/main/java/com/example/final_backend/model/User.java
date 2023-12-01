package com.example.final_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;



@Document(collection = "users")
public class User {
    @Id
    private String id;


    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;


    public User() {
    }

    public User(String username, String password) {
        this.username = username; // Username is unique
        this.password = password;
    }


    // Standard getters and setters
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password; // Password is hashed
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username; // Username is unique
    }

    public void setId(String id) {
        this.id = id;
    }
}
