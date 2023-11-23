package com.example.final_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("records")
public class Record {

    @Id
    private String mongoId;  // Renamed to represent MongoDB's document ID
    private String id;
    private String savingName;
    private int health;
    private int strength;
    private int defense;
    private int speed;
    private int level;
    private String name;
    private String imagePath;
    private int monsterKilled;
    private int points;

    public Record( String id, String savingName, int health, int strength, int defense, int speed, int level, String name, String imagePath, int monsterKilled, int points) {
        this.id = id;
        this.savingName = savingName;
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.speed = speed;
        this.level = level;
        this.name = name;
        this.imagePath = imagePath;
        this.monsterKilled = monsterKilled;
        this.points = points;
    }
    // Standard getters and setters
}
