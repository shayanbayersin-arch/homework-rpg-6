package com.narxoz.rpg.arena;

import java.util.ArrayList;
import java.util.List;

public class ArenaFighter {
    private final String name;
    private int health;
    private final int maxHealth;
    private double dodgeChance;
    private final int blockRating;
    private final int armorValue;
    private final int attackPower;
    private int healPotions;

    public ArenaFighter(String name, int health, double dodgeChance, int blockRating, int armorValue, int attackPower, int healPotions) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.dodgeChance = dodgeChance;
        this.blockRating = blockRating;
        this.armorValue = armorValue;
        this.attackPower = attackPower;
        this.healPotions = healPotions;
    }

    public void takeDamage(int amount) {
        this.health = Math.max(0, this.health - amount);
    }

    public void heal(int amount) {
        if (healPotions > 0) {
            int oldHealth = health;
            this.health = Math.min(maxHealth, this.health + amount);
            this.healPotions--;
            System.out.println("    [Heal] " + name + " used a potion! +" + (health - oldHealth) + " HP. Potions left: " + healPotions);
        }
    }

    public void modifyDodgeChance(double delta) {
        this.dodgeChance = Math.max(0.0, Math.min(1.0, this.dodgeChance + delta));
    }

    public boolean isAlive() { return health > 0; }
    // Getters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public double getDodgeChance() { return dodgeChance; }
    public int getBlockRating() { return blockRating; }
    public int getArmorValue() { return armorValue; }
    public int getAttackPower() { return attackPower; }
    public int getHealPotions() { return healPotions; }
}