package com.example.final_backend.controller;

import com.example.final_backend.model.Record;
import com.example.final_backend.repo.RecordRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordRepo recordRepo;
    
    @GetMapping
    public String hello() {
      return "hello world!";
    }
  
    @PostMapping
    public Record createRecord(@RequestBody Record record) {
        System.out.println("Received record: " + record);
        return recordRepo.save(record);
    }

    
}