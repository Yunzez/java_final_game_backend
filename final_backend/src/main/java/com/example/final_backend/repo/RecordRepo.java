package com.example.final_backend.repo;

import com.example.final_backend.model.Record;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RecordRepo extends MongoRepository<Record, String> {
    // Define custom query methods here if necessary

    Page<Record> findAll(Pageable pageable);

    @Query("{ 'userId' : ?0 }")
    Optional<Record> findByUserId(String userId);

    @Query("{}")
    List<Record> findTop100Records();
}
