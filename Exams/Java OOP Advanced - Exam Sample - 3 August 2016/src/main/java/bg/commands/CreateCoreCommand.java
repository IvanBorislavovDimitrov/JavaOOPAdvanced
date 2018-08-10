package bg.commands;

import bg.contracts.Manager;

public class CreateCoreCommand implements Command {
    @Override
    public String execute(Manager manager, String... params) {
        String type = params[0];
        int durability = Integer.parseInt(params[1]);

        return manager.createCore(type, durability);
    }
}
