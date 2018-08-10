package bg.commands;

import bg.contracts.Manager;

public class DetachFragmentCommand implements Command {
    @Override
    public String execute(Manager manager, String... params) {
        return manager.detachFragment();
    }
}
