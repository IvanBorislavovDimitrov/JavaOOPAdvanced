package app.commands;

import app.contracts.Battlefield;

public interface Command {

    void execute(Battlefield battlefield, String... params);
}
