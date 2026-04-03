package com.narxoz.rpg.command;

import java.util.ArrayList;
import java.util.List;

public class ActionQueue {
    private final List<ActionCommand> queue = new ArrayList<>();

    public void enqueue(ActionCommand cmd) {
    }

    public void undoLast() {
    }

    public void executeAll() {
    }

    public List<String> getCommandDescriptions() {
        return new ArrayList<>();
    }
}
