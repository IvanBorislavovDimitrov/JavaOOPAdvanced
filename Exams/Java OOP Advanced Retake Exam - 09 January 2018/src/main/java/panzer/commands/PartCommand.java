package panzer.commands;

import panzer.contracts.Manager;

import java.util.Arrays;

public class PartCommand implements Command {
    @Override
    public String execute(Manager manager, String... params) {
        return manager.addPart(Arrays.asList(params[0], params[1], params[2], params[3], params[4], params[5]));
    }
}
