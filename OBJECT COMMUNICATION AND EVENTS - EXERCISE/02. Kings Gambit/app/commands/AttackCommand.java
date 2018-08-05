package app.commands;

import app.kingdom.Kingdom;
import app.models.BasePerson;

public class AttackCommand implements Command {
    @Override
    public String execute(Kingdom kingdom, String name) {
        return kingdom.attack();
    }
}
