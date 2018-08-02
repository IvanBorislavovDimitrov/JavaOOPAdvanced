package src.command.impl;

import src.annotations.Inject;
import src.command.interfaces.Command;
import src.models.api.Attacker;

public class AttackCommand implements Command {

    @Inject
    private Attacker attacker;


    @Override
    public void execute() {
        this.attacker.attack();
    }
}
