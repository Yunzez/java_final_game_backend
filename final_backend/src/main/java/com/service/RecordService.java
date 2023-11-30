package com.service;

import org.springframework.stereotype.Service;

import com.example.final_backend.model.Record;

import java.util.List;

@Service
public interface RecordService {
    public List<Record> getFirst100Records();
    public Record saveRecord(Record record);
    public List<Record> getRecordsByUserId(String userId);
}
