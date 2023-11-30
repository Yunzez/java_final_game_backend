package com.example.final_backend.service;

import com.example.final_backend.model.Record;

import java.util.List;

public interface RecordService {
    public List<Record> getFirst100Records();
    public Record saveRecord(Record record);
    public Record getRecordsByUserId(long userId);
}
