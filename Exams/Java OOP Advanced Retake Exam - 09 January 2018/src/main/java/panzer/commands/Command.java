package panzer.commands;

import panzer.contracts.Manager;

public interface Command {

    String execute(Manager manager, String... params);
}
