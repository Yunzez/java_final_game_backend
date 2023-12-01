package com.example.final_backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexDefinition;

import com.example.final_backend.model.User;
import org.springframework.data.domain.Sort;

import javax.annotation.PostConstruct;

@Configuration
public class MongoConfig {

    @Autowired
    private MongoOperations mongoOperations;

    @PostConstruct
    public void initIndices() {
        createUniqueIndex();
    }

    private void createUniqueIndex() {
        IndexDefinition indexDefinition = new Index().on("username", Sort.Direction.ASC).unique();
        mongoOperations.indexOps(User.class).ensureIndex(indexDefinition);
    }
}
