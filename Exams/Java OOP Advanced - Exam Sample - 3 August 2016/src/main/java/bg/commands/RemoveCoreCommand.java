package bg.commands;

import bg.contracts.Manager;

public class RemoveCoreCommand implements Command {
    @Override
    public String execute(Manager manager, String... params) {

        return manager.removeCore(params[0].charAt(0));
    }
}