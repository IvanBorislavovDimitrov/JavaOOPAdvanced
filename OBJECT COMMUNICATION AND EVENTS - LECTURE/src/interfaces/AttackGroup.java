package src.interfaces;

import src.models.api.Attacker;
import src.models.api.Target;

public interface AttackGroup {

    void addMember(Attacker attacker);

    void groupTarget(Target target);

    void groupAttack();
}
