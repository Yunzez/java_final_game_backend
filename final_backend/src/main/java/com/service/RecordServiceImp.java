package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.final_backend.repo.RecordRepo;
import com.example.final_backend.model.Record;

import java.util.List;

@Service
public class RecordServiceImp implements RecordService{

    @Autowired
    private RecordRepo recordRepo;

    public List<Record> getFirst100Records() {
        Page<Record> page = recordRepo.findAll(PageRequest.of(0, 100));
        System.out.println("Retrieved " + page.getTotalElements() + " records.");
        System.out.println(page.getContent());
        return page.getContent();
    }

    public Record saveRecord(Record record) {
        System.out.println("Received record: " + record);
        return recordRepo.save(record);
    }

    public List<Record> getRecordsByUserId(String userId) {
        return recordRepo.findByUserId(userId);
    }

}
