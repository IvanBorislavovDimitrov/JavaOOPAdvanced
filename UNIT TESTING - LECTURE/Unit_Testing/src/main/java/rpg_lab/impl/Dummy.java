package rpg_lab.impl;

import rpg_lab.api.Target;
import rpg_lab.api.Weapon;

import java.util.List;
import java.util.Random;

public class Dummy implements Target {

    private int health;
    private int experience;
    private List<Weapon> loot;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.loot = List.of(new Axe(10, 20), new Axe(20, 20), new Axe(40, 40));
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public Weapon getLoot() {
        if (!isDead()) {
            return this.loot.get(new Random().nextInt(this.loot.size()));
        }

        throw new IllegalArgumentException("No loop!");
    }
}
