package com.narxoz.rpg.adapterandcomposite;

import com.narxoz.rpg.arena.ArenaOpponent;
import java.util.ArrayList;
import java.util.List;

public class EnemySquad extends ArenaOpponent {
    private List<ArenaOpponent> members = new ArrayList<>();

    public EnemySquad(String name) {
        super(name, 0, 0);
    }

    public void addMember(ArenaOpponent opponent) {
        members.add(opponent);
    }

    @Override
    public int getHealth() {
        return members.stream().mapToInt(ArenaOpponent::getHealth).sum();
    }

    @Override
    public int getAttackPower() {
        return members.stream().filter(ArenaOpponent::isAlive).mapToInt(ArenaOpponent::getAttackPower).sum();
    }

    @Override
    public void takeDamage(int amount) {
        // Урон распределяется по живым членам отряда
        for (ArenaOpponent m : members) {
            if (m.isAlive()) {
                m.takeDamage(amount);
                break;
            }
        }
    }

    @Override
    public boolean isAlive() {
        return members.stream().anyMatch(ArenaOpponent::isAlive);
    }
}