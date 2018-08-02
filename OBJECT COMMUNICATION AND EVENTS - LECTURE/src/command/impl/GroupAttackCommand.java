package src.command.impl;

import src.annotations.Inject;
import src.command.interfaces.Command;
import src.interfaces.AttackGroup;

public class GroupAttackCommand implements Command {

    @Inject
    private AttackGroup attackGroup;

    @Override
    public void execute() {
        this.attackGroup.groupAttack();
    }
}
