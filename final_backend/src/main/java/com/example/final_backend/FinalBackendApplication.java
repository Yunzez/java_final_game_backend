package com.example.final_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// import org.springframework.beans.factory.annotation.Autowired;
// import com.example.final_backend.repo.RecordRepo;
// import com.example.final_backend.repo.UserRepo;
// import com.example.final_backend.model.Record;

// import com.mongodb.ConnectionString;
// import com.mongodb.MongoClientSettings;
// import com.mongodb.MongoException;
// import com.mongodb.ServerApi;
// import com.mongodb.ServerApiVersion;
// import com.mongodb.client.MongoClient;
// import com.mongodb.client.MongoClients;
// import com.mongodb.client.MongoDatabase;

// import java.util.ArrayList;
// import java.util.List;

// import org.bson.Document;

@SpringBootApplication
public class FinalBackendApplication implements CommandLineRunner {

    // @Autowired
    // private RecordRepo recordRepository;

    // @Autowired
    // private UserRepo userRepository;

    public static void main(String[] args) {
        SpringApplication.run(FinalBackendApplication.class, args);
    }

    // this method should be removed in production
    @Override
    public void run(String... args) throws Exception {
        // // delete all records
        // recordRepository.deleteAll();
        // userRepository.deleteAll();

        // // generate some random records for development
        // List<Record> records = new ArrayList<>();
        // for (int i = 0; i < 200; i++) {
        // Record record = new Record(
        // "id" + i,
        // "savingName" + i,
        // 100, // Health
        // 50, // Strength
        // 30, // Defense
        // 20, // Speed
        // i, // Level
        // "name" + i,
        // "imagePath" + i,
        // i * 10, // Monsters Killed
        // i * 100, // Points
        // i+""
        // );
        // records.add(record);
        // }
        // recordRepository.saveAll(records);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
