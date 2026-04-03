package com.narxoz.rpg.bridge;
public class Weapon {
    protected DamageEffect effect;
    public Weapon(DamageEffect e) {
        this.effect = e;
    }
    public int getFinalDamage(int base) {
        return base + effect.extraDamage();
    }
}