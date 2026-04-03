package com.narxoz.rpg.command;
import com.narxoz.rpg.arena.ArenaOpponent;

public class AttackCommand implements Command {
    private ArenaOpponent target; private int dmg;
    public AttackCommand(ArenaOpponent t, int d) { this.target = t; this.dmg = d; }
    public void execute() { target.takeDamage(dmg); }
    public void undo() { /* Логика возврата HP */ }
}