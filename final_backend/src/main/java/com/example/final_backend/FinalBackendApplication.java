package com.example.final_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.final_backend.repo.RecordRepo;
import com.example.final_backend.model.Record;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

@SpringBootApplication
public class FinalBackendApplication implements CommandLineRunner {

    @Autowired
    private RecordRepo recordRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinalBackendApplication.class, args);

		// String connectionString = "mongodb+srv://zhaoyunzeabh:Zyz20928%40cn@cluster0.wyhtgjx.mongodb.net/?retryWrites=true&w=majority";
        // ServerApi serverApi = ServerApi.builder()
        //         .version(ServerApiVersion.V1)
        //         .build();
        // MongoClientSettings settings = MongoClientSettings.builder()
        //         .applyConnectionString(new ConnectionString(connectionString))
        //         .serverApi(serverApi)
        //         .build();
        // // Create a new client and connect to the server
        // try (MongoClient mongoClient = MongoClients.create(settings)) {
        //     try {
        //         // Send a ping to confirm a successful connection
        //         MongoDatabase database = mongoClient.getDatabase("admin");
        //         database.runCommand(new Document("ping", 1));
        //         System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
        //     } catch (MongoException e) {
        //         e.printStackTrace();
        //     }
        // }

	}

    @Override
    public void run(String... args) throws Exception {
        // delete all records
        recordRepository.deleteAll();

        //
        List<Record> records = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Record record = new Record(
                    "id" + i,
                    "savingName" + i,
                    100, // Health
                    50,  // Strength
                    30,  // Defense
                    20,  // Speed
                    i,   // Level
                    "name" + i,
                    "imagePath" + i,
                    i * 10, // Monsters Killed
                    i * 100, // Points
                    "userId" + i
            );
            records.add(record);
        }
        recordRepository.saveAll(records);
    }




}
