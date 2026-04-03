package com.narxoz.rpg.composite;
import com.narxoz.rpg.arena.ArenaFighter;
import java.util.*;

public class EnemySquad extends ArenaFighter {
    private List<ArenaFighter> members = new ArrayList<>();
    public EnemySquad(String name) {
        super(name, 0, 0, 0, 0);
    }
    public void addMember(ArenaFighter f) {
        members.add(f);
    }
    @Override
    public int getHealth() {
        return members.stream().mapToInt(ArenaFighter::getHealth).sum();
    }
    @Override
    public void takeDamage(int dmg) {
        members.forEach(m -> m.takeDamage(dmg/members.size()));
    }
}