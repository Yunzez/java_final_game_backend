package com.example.final_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String username;
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
