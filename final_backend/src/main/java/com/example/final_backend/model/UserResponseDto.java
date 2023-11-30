package com.example.final_backend.model;

public class UserResponseDto {
    private String id;
    private String username;

    public UserResponseDto(String username, String id) {
        this.id = id;
        this.username = username;
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
