package com.example.final_backend.controller;

import com.example.final_backend.model.Record;
import com.example.final_backend.repo.RecordRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordRepo recordRepo;
    
   @GetMapping
    public List<Record> getFirst100Records() {
        Page<Record> page = recordRepo.findAll(PageRequest.of(0, 100));
        System.out.println("Retrieved " + page.getTotalElements() + " records.");
        System.out.println(page.getContent());
        return page.getContent();
    }
    @PostMapping
    public Record createRecord(@RequestBody Record record) {
        System.out.println("Received record: " + record);
        return recordRepo.save(record);
    }

    
}