package com.example.final_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.final_backend.exception.DocumentNotFoundException;
import com.example.final_backend.model.User;
import com.example.final_backend.repo.UserRepo;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User getUser(String userId) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new DocumentNotFoundException("User not found with id: " + userId);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new DocumentNotFoundException("User not found with username: " + username);
        }
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

}
