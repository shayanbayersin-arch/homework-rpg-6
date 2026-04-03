package com.narxoz.rpg.command;
import com.narxoz.rpg.arena.ArenaFighter;

class AttackCommand implements Command {
    private ArenaFighter target; private int dmg;
    public AttackCommand(ArenaFighter t, int d) { this.target = t; this.dmg = d; }
    public void execute() { target.takeDamage(dmg); }
    public void undo() { /* Логика возврата HP */ }
}