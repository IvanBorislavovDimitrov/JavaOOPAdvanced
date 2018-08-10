package bg.commands;

import bg.contracts.Manager;

public class SelectCoreCommand implements Command {
    @Override
    public String execute(Manager manager, String... params) {
        return manager.selectCore(params[0].charAt(0));
    }
}
