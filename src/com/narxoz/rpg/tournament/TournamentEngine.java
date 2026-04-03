package com.narxoz.rpg.tournament;

import com.narxoz.rpg.arena.ArenaFighter;
import com.narxoz.rpg.arena.ArenaOpponent;
import com.narxoz.rpg.arena.TournamentResult;
import com.narxoz.rpg.chain.*;
import com.narxoz.rpg.command.*;
import java.util.Random;

public class TournamentEngine {
    private final ArenaFighter hero;
    private final ArenaOpponent opponent;
    private Random random = new Random(1L);

    public TournamentEngine(ArenaFighter hero, ArenaOpponent opponent) {
        this.hero = hero;
        this.opponent = opponent;
    }

    public TournamentEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public TournamentResult runTournament() {
        TournamentResult result = new TournamentResult();
        int round = 0;
        final int maxRounds = 20;

        // 1. Собираем цепочку обязанностей (Chain of Responsibility)
        // Dodge -> Block -> Armor -> HP
        DefenseHandler dodge = new DodgeHandler(hero.getDodgeChance(), random.nextLong());
        DefenseHandler block = new BlockHandler(hero.getBlockRating() / 100.0);
        DefenseHandler armor = new ArmorHandler(hero.getArmorValue());
        DefenseHandler hp = new HpHandler();

        // Связываем их в цепочку
        dodge.setNext(block);
        block.setNext(armor);
        armor.setNext(hp);

        // 2. Создаем очередь действий (Command Pattern Invoker)
        ActionQueue actionQueue = new ActionQueue();

        // 3. Симуляция боя
        while (hero.isAlive() && opponent.isAlive() && round < maxRounds) {
            round++;
            result.addLine("\n--- Round " + round + " ---");

            // Наполняем очередь действиями героя
            // Атака
            actionQueue.enqueue(new AttackCommand(opponent, hero.getAttackPower()));

            // Если здоровья мало — лечимся
            if (hero.getHealth() < hero.getMaxHealth() * 0.5) {
                actionQueue.enqueue(new HealCommand(hero, 25));
            }

            // Защитная стойка (небольшой бонус к уклонению)
            actionQueue.enqueue(new DefendCommand(hero, 0.1));

            // Показываем, что мы запланировали (для терминала)
            System.out.println("Planned actions: " + actionQueue.getCommandDescriptions());

            // Выполняем все команды героя
            actionQueue.executeAll();

            // Если оппонент выжил, он атакует в ответ
            if (opponent.isAlive()) {
                result.addLine(opponent.getName() + " strikes back with " + opponent.getAttackPower() + " power!");

                // Пропускаем атаку через цепочку защиты героя
                // Здесь магия: мы не вызываем takeDamage напрямую!
                dodge.handle(opponent.getAttackPower(), hero);
            }

            // Логируем состояние раунда
            String status = String.format("[End of Round %d] %s HP: %d | %s HP: %d",
                    round, hero.getName(), hero.getHealth(), opponent.getName(), opponent.getHealth());
            result.addLine(status);
        }

        // 4. Определяем победителя
        String winnerName = hero.isAlive() ? hero.getName() : opponent.getName();
        result.setWinner(winnerName);
        result.setRounds(round);

        result.addLine("\n==============================");
        result.addLine("WINNER: " + winnerName.toUpperCase());
        result.addLine("==============================");

        return result;
    }
}