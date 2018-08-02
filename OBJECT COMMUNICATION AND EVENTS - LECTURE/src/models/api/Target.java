package src.models.api;

import src.command.interfaces.Subject;

public interface Target extends Subject {
    void receiveDamage(int dmg);
    boolean isDead();
}