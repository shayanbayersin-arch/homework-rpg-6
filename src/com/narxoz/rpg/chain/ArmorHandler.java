package com.narxoz.rpg.chain;
import com.narxoz.rpg.arena.ArenaFighter;

public class ArmorHandler extends DefenseHandler {
    public ArmorHandler(int armorValue) {
        super();
    }

    public void handle(int dmg, ArenaFighter t) {
        int finalDmg = Math.max(0, dmg - t.getArmor());
        System.out.println("Armor reduced damage to: " + finalDmg);
        if (next != null) next.handle(finalDmg, t);
    }
}