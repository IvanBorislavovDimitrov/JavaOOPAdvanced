package rpg_lab.api;

import rpg_lab.impl.Dummy;

public interface Weapon {
    int getAttackPoints();

    int getDurabilityPoints();

    void attack(Target target);
}
