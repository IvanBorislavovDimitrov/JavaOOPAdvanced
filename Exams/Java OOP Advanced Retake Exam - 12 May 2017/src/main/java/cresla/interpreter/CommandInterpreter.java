package cresla.interpreter;

import cresla.interfaces.Manager;

import java.util.Arrays;

public class CommandInterpreter {

    private Manager manager;

    public CommandInterpreter(Manager manager) {
        this.manager = manager;
    }

    public String executeCommand(String[] args) {
        String command = args[0];

        switch (command) {
            case "Reactor":
                return this.manager.reactorCommand(Arrays.asList(Arrays.stream(args).skip(1).toArray(String[]::new)));
            case "Module":
                return this.manager.moduleCommand(Arrays.asList(Arrays.stream(args).skip(1).toArray(String[]::new)));
            case "Report":
                return this.manager.reportCommand(Arrays.asList(Arrays.stream(args).skip(1).toArray(String[]::new)));
            case "Exit":
                return this.manager.exitCommand(Arrays.asList(Arrays.stream(args).skip(1).toArray(String[]::new)));
        }

        throw new IllegalArgumentException(String.format("Not a valid command %s!",command));
    }

}
