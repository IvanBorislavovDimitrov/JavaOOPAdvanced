package src.command.impl;

import src.annotations.Inject;
import src.command.interfaces.Command;
import src.models.api.Attacker;
import src.models.api.Target;

public class TargetCommand implements Command {

    @Inject
    private Attacker attacker;

    @Inject
    private Target target;

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
    }
}
