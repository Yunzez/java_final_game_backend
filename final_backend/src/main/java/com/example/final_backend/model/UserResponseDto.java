package com.example.final_backend.model;

public class UserResponseDto {
    private String username;
    private String id;

    public UserResponseDto(String username, String id) {
        this.username = username;
        this.id = id;
    }

    public UserResponseDto() {
    }

    // Standard getters and setters
    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(String id) {
        this.id = id;
    }

}
