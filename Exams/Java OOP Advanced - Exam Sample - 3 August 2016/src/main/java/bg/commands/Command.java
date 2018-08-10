package bg.commands;

import bg.contracts.Manager;

public interface Command {

    String execute(Manager manager, String... params);
}
