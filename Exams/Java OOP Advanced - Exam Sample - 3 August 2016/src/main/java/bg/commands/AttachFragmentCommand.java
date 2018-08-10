package bg.commands;

import bg.contracts.Manager;

public class AttachFragmentCommand implements Command {
    @Override
    public String execute(Manager manager, String... params) {
        String type = params[0];
        String name = params[1];
        int pressure = Integer.parseInt(params[2]);

        return manager.attachFragment(type, name, pressure);
    }
}
