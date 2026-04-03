package com.narxoz.rpg.decorator;
import com.narxoz.rpg.arena.ArenaFighter;

public class PowerBuff extends ArenaFighter {
    private ArenaFighter decorated;

    public PowerBuff(ArenaFighter f) {
        super(f.getName(), f.getHealth(), f.getDodgeChance(), f.getBlockRating(), f.getArmorValue(), f.getAttackPower(), f.getHealPotions());
        this.decorated = f;
    }

    @Override
    public int getAttackPower() {
        return decorated.getAttackPower() + 10;
    }
}