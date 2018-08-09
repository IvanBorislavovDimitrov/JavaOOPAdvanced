package app.abilities;

import app.contracts.Hero;

public abstract class Ability {

    private Hero hero;
    private double startHealth;

    public Ability() {
    }

    public double getStartHealth() {
        return this.startHealth;
    }

    public void setStartHealth(double startHealth) {
        this.startHealth = startHealth;
    }

    public abstract void gain();

    public Hero getHero() {
        return this.hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
