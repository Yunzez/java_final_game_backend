package com.example.final_backend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.final_backend.model.User;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {
    // Define custom query methods here if necessary
    @Query("{ 'username' : ?0 }")
    Optional<User> findByUsername(String username);

    @Query("{ 'id' : ?0 }")
    Optional<User> findById(String id);
}
