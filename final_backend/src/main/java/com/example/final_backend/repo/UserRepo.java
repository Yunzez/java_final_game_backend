package com.example.final_backend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.final_backend.model.User;

public interface UserRepo extends MongoRepository<User, String> {
    // Define custom query methods here if necessary
    User findByUsername(String username);

}
