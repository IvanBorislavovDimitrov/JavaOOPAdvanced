package panzer.commands;

import panzer.contracts.Manager;

import java.util.ArrayList;

public class TerminateCommand implements Command {
    @Override
    public String execute(Manager manager, String... params) {
        return manager.terminate(new ArrayList<>());
    }
}
