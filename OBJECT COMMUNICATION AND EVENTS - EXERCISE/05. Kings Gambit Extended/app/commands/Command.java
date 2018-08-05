package app.commands;

import app.kingdom.Kingdom;
import app.models.BasePerson;

public interface Command {

    String execute(Kingdom kingdom, String name);
}
