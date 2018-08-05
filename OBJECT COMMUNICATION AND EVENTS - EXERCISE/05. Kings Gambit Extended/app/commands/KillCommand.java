package app.commands;

import app.kingdom.Kingdom;
import app.models.BasePerson;

public class KillCommand implements Command {
    @Override
    public String execute(Kingdom kingdom, String name) {
        kingdom.kill(name);

        return null;
    }
}
