package com.narxoz.rpg.command;

import java.util.ArrayList;
import java.util.List;

public class ActionQueue {
    private List<ActionCommand> commands = new ArrayList<>();


    public void enqueue(ActionCommand cmd) {
        commands.add(cmd);
    }

    public void executeAll() {
        for (ActionCommand cmd : commands) {
            cmd.execute();
        }
        commands.clear();
    }

    public List<String> getCommandDescriptions() {
        List<String> descriptions = new ArrayList<>();
        for (ActionCommand cmd : commands) {
            descriptions.add(cmd.getDescription());
        }
        return descriptions;
    }
}