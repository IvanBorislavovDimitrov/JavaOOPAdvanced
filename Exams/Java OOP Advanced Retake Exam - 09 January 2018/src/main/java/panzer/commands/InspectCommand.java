package panzer.commands;

import panzer.contracts.Manager;

import java.util.Arrays;

public class InspectCommand implements Command {
    @Override
    public String execute(Manager manager, String... params) {
        return manager.inspect(Arrays.asList(params[0]));
    }
}
