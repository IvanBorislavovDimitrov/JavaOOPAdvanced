package app.models.participants;

import app.abilities.Ability;
import app.abilities.Swiftness;
import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public abstract class BaseHero implements Hero {

    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private double gold;
    private double health;
    private Ability ability;

    public BaseHero() {
        this.setHealth(this.strength * Config.HERO_HEALTH_MULTIPLIER);
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
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
    }

    public void receiveReward(double reward) {
        this.gold += reward;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

    @Override
    public void levelUp() {
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.setStrength(this.getStrength() * 2);
        this.setDexterity(this.getDexterity() * 2);
        this.setIntelligence(this.getIntelligence() * 2);
        this.setLevel(this.getLevel() + 1);
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public abstract double getDamage();

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
        this.setHealth(strength * Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public int getDexterity() {
        return this.dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return this.intelligence;
    }


    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.getGold()));

        return sb.toString();
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    public Ability getAbility() {
        return this.ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    @Override
    public Ability getSpecial() {
        return null;
    }

    @Override
    public void setSpecial(Ability ability) {
        this.ability = ability;
        this.ability.setHero(this);
        this.getAbility().setStartHealth(this.getHealth());
    }

    @Override
    public void addStrength(double value) {
        this.strength += value;
    }
}
