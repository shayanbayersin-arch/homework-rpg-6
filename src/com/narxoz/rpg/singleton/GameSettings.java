package com.narxoz.rpg.singleton;

public class GameSettings {
    private static GameSettings instance;
    private String difficulty = "Normal";

    private GameSettings() {}

    public static GameSettings getInstance() {
        if (instance == null) instance = new GameSettings();
        return instance;
    }
    public void setDifficulty(String d) { this.difficulty = d; }
    public String getDifficulty() { return difficulty; }
}