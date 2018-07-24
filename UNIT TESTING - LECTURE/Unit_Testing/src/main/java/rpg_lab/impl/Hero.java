package rpg_lab.impl;

import rpg_lab.api.Target;
import rpg_lab.api.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> unequippedWeapons;

    public Hero() {
        this.unequippedWeapons = new ArrayList<>();
    }

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
        this.unequippedWeapons = new ArrayList<Weapon>();
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
        }
    }

    public void addWeapon(Weapon weapon) {
        this.unequippedWeapons.add(weapon);
    }

    public List<Weapon> getUnequippedWeapons() {
        return this.unequippedWeapons;
    }
}
