package src.command.impl;

import src.annotations.Inject;
import src.command.interfaces.Command;
import src.interfaces.AttackGroup;
import src.models.api.Target;

public class GroupTargetCommand implements Command {

    @Inject
    private AttackGroup attackGroup;

    @Inject
    private Target target;

    @Override
    public void execute() {
        this.attackGroup.groupTarget(this.target);
    }
}
