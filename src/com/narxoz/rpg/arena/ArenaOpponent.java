package com.narxoz.rpg.arena;

public class ArenaOpponent {
    private final String name;
    private int health;
    private final int maxHealth;
    private final int attackPower;

    public ArenaOpponent(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attackPower = attackPower;
    }

    public void takeDamage(int amount) { this.health = Math.max(0, this.health - amount); }
    public void restoreHealth(int amount) { this.health = Math.min(maxHealth, this.health + amount); }
    public boolean isAlive() { return health > 0; }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttackPower() { return attackPower; }
}