package app.models.participants;

import app.abilities.Ability;
import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public abstract class BaseTargetable implements Targetable {

    private String name;
    private double health;
    private double gold;
    private int level;
    private Ability ability;

    protected BaseTargetable(String name, double health, double gold, int level) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
    }

    @Override
    public void receiveReward(double reward) {
        this.setGold(this.getGold() + reward);
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()) {
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.getGold());
        this.setGold(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()));

        return sb.toString();
    }

    public Ability getAbility() {
        return this.ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
        this.ability.setHero((Hero) this);
        this.ability.setStartHealth(this.health);
    }
}
