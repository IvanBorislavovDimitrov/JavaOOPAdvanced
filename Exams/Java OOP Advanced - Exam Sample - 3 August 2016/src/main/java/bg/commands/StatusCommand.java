package bg.commands;

import bg.contracts.Manager;

public class StatusCommand implements Command {
    @Override
    public String execute(Manager manager, String... params) {
        return manager.status();
    }
}
