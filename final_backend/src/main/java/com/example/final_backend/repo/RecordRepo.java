package com.example.final_backend.repo;

import com.example.final_backend.model.Record;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecordRepo extends MongoRepository<Record, String> {
    // Define custom query methods here if necessary
}
