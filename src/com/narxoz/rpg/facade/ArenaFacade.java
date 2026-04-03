package com.narxoz.rpg.facade;

import com.narxoz.rpg.arena.ArenaFighter;
import com.narxoz.rpg.arena.ArenaOpponent;
import com.narxoz.rpg.arena.TournamentResult;
import com.narxoz.rpg.bridge.FireEffect;
import com.narxoz.rpg.bridge.Weapon;
import com.narxoz.rpg.composite.EnemySquad;
import com.narxoz.rpg.decorator.PowerBuff;
import com.narxoz.rpg.singleton.GameSettings;
import com.narxoz.rpg.tournament.TournamentEngine;
import com.narxoz.rpg.arena.ArenaFighter;
import com.narxoz.rpg.arena.ArenaOpponent;
import com.narxoz.rpg.composite.EnemySquad;
import com.narxoz.rpg.command.*; // Чтобы видел AttackCommand и т.д.
import com.narxoz.rpg.tournament.TournamentEngine;

public class ArenaFacade {

    public void startTournament() {
        System.out.println("==============================================");
        System.out.println("   WELCOME TO THE GRAND DESIGN PATTERN ARENA  ");
        System.out.println("==============================================\n");


        GameSettings settings = GameSettings.getInstance();
        settings.setDifficulty("Hard");
        System.out.println("[System] Difficulty set to: " + settings.getDifficulty());


        Weapon fireSword = new Weapon(new FireEffect());
        int heroDamage = fireSword.getFinalDamage(20);
        System.out.println("[System] Hero forged a Fire Sword! Damage: " + heroDamage);

        ArenaFighter baseHero = new ArenaFighter("Erlan", 120, heroDamage, 0.2, 30, 5, 3);


        ArenaFighter buffedHero = new PowerBuff(baseHero);
        System.out.println("[System] Hero " + buffedHero.getName() + " entered the arena.");


        EnemySquad squad = new EnemySquad("Undead Legion");
        squad.addMember(new ArenaOpponent("Skeleton Warrior", 40, 12));
        squad.addMember(new ArenaOpponent("Zombie Berserker", 60, 15));

        System.out.println("[System] Opponent: " + squad.getName() + " (Multiple enemies)");
        System.out.println("----------------------------------------------");


        TournamentEngine engine = new TournamentEngine(buffedHero, squad);
        engine.setRandomSeed(42L);

        TournamentResult result = engine.runTournament();


        System.out.println("\n==============================================");
        System.out.println("            TOURNAMENT OVER");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Total Rounds: " + result.getRounds());
        System.out.println("==============================================");
    }
}