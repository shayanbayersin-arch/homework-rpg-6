package com.narxoz.rpg.arena;

public class ArenaFighter {
    private String name;
    private int health;
    private int attackPower;
    private double dodgeChance;
    private int armor;

    public ArenaFighter(String name, int health, int attackPower, double dodge, int armor) {
        this.name = name; this.health = health; this.attackPower = attackPower;
        this.dodgeChance = dodge; this.armor = armor;
    }
    public void takeDamage(int dmg) { this.health = Math.max(0, this.health - dmg); }
    public boolean isAlive() { return health > 0; }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttackPower() { return attackPower; }
    public double getDodgeChance() { return dodgeChance; }
    public int getArmor() { return armor; }
}