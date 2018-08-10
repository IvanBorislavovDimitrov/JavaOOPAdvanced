package panzer.commands;

import panzer.contracts.Manager;

import java.util.Arrays;

public class BattleCommand implements Command {
    @Override
    public String execute(Manager manager, String... params) {
        return manager.battle(Arrays.asList(params[0], params[1]));
    }
}
