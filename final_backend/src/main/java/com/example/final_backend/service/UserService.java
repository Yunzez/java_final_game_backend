package com.example.final_backend.service;

import com.example.final_backend.model.User;

public interface UserService {
    User getUser(String userId);
    User getUserByUsername(String username);
    User saveUser(User user);
}
