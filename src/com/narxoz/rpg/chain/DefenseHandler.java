package com.narxoz.rpg.chain;
import com.narxoz.rpg.arena.ArenaFighter;

public abstract class DefenseHandler {
    protected DefenseHandler next;
    public void setNext(DefenseHandler n) {
        this.next = n;
    }
    public abstract void handle(int dmg, ArenaFighter target);
}