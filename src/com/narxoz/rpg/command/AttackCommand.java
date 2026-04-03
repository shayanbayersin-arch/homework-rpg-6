package com.narxoz.rpg.command;
import com.narxoz.rpg.arena.ArenaOpponent;

public class AttackCommand implements ActionCommand {
    private ArenaOpponent target;
    private int dmg;

    public AttackCommand(ArenaOpponent t, int d) {
        this.target = t;
        this.dmg = d;
    }

    @Override
    public void execute() {
        target.takeDamage(dmg);
    }

    @Override
    public void undo() {
    }

    @Override
    public String getDescription() {
        return "Атакует противника, нанося " + dmg + " урона.";
    }
}