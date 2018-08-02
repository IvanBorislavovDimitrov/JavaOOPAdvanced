package src.groups;

import src.interfaces.AttackGroup;
import src.models.api.Attacker;
import src.models.api.Target;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {

    private List<Attacker> attackers;

    public Group() {
        this.attackers = new ArrayList<>();
    }

    public void groupAttackCommand(AttackGroup attackGroup) {
        attackGroup.groupAttack();
    }

    public void groupTargetCommand(AttackGroup attackGroup, Target target) {
        attackGroup.groupTarget(target);
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(Target target) {
        this.attackers.forEach(a -> a.setTarget(target));
    }

    @Override
    public void groupAttack() {
        this.attackers.forEach(Attacker::attack);
    }
}
