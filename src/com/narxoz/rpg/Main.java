package com.narxoz.rpg;

import com.narxoz.rpg.facade.ArenaFacade;

public class Main {
    public static void main(String[] args) {
        ArenaFacade game = new ArenaFacade();
        game.startTournament();
    }
}