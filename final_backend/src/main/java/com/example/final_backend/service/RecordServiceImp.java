package com.example.final_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.final_backend.repo.RecordRepo;
import com.example.final_backend.exception.DocumentNotFoundException;
import com.example.final_backend.model.Record;

import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImp implements RecordService{

    @Autowired
    private RecordRepo recordRepo;

    public List<Record> getFirst100Records() {
        Page<Record> page = recordRepo.findAll(PageRequest.of(0, 100));
        // System.out.println("Retrieved " + page.getTotalElements() + " records.");
        // System.out.println(page.getContent());
        return page.getContent();
    }

    public Record saveRecord(Record record) {
        Record existingRecord = recordRepo.findByUserId(record.getUserId()).orElse(null);
        if (existingRecord != null) {
            record.setMongoId(existingRecord.getMongoId());
        }
        // System.out.println("Received record: " + record);
        return recordRepo.save(record);
    }

    public Record getRecordsByUserId(String userId) {
        Optional<Record>  record = recordRepo.findByUserId(userId);
        if (record.isPresent()) {
            return record.get();
        } else {
            throw new DocumentNotFoundException("Record not found with userId: " + userId);
        }
    }

}
