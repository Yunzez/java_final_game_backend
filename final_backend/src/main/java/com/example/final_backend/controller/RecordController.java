package com.example.final_backend.controller;

import com.example.final_backend.model.Record;
import com.example.final_backend.service.RecordService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    @Autowired
    private RecordService recordSerivce;

   @GetMapping
    public ResponseEntity<List<Record>> getFirst100Records() {
        return new ResponseEntity<>(recordSerivce.getFirst100Records(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> createRecord(@RequestBody Record record) {
        return new ResponseEntity<>(recordSerivce.saveRecord(record), HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Record> getRecordsByUserId(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(recordSerivce.getRecordsByUserId(userId), HttpStatus.OK);
    }
}