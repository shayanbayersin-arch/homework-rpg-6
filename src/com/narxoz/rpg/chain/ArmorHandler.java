package com.narxoz.rpg.chain;
import com.narxoz.rpg.arena.ArenaFighter;

public class ArmorHandler extends DefenseHandler {
    private int armorValue;

    public ArmorHandler(int armorValue) {
        this.armorValue = armorValue;
    }
    @Override
    public void handle(int dmg, ArenaFighter t) {
        int finalDmg = Math.max(0, dmg - t.getArmorValue());
        System.out.println("Armor reduced damage to: " + finalDmg);
        if (next != null) next.handle(finalDmg, t);
    }
}