package com.example.final_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;


@Document(collection = "records")
public class Record {

    @JsonIgnore
    @Id
    private String mongoId; // Renamed to represent MongoDB's document ID
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

    @NotBlank(message = "userId is required")
    private String userId; // Added to represent the user ID

    public Record() {
    }

    public Record(String id, String savingName, int health, int strength, int defense, int speed, int level,
            String name, String imagePath, int monsterKilled, int points, String userId) {
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
        this.userId = userId;
    }

    // Standard getters and setters
    public String getMongoId() {
        return mongoId;
    }

    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }


    public String getId() {
        return id;
    }

    public String getSavingName() {
        return savingName;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getMonsterKilled() {
        return monsterKilled;
    }

    public int getPoints() {
        return points;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSavingName(String savingName) {
        this.savingName = savingName;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setMonsterKilled(int monsterKilled) {
        this.monsterKilled = monsterKilled;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
