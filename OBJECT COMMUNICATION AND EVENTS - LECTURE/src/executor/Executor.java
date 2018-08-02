package src.executor;

import src.command.interfaces.Command;

public interface Executor {

    void executeCommand(Command command);
}
