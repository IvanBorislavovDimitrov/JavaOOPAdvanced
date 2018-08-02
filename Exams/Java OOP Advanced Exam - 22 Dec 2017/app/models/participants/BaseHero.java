package app.models.participants;

import app.contracts.Hero;
import app.models.Config;

public abstract class BaseHero extends BaseTargetable implements Hero {

    private int strength;
    private int dexterity;
    private int intelligence;

    protected BaseHero() {
        this.setLevel(1);
        this.setGold(Config.HERO_START_GOLD);
    }

    public void levelUp() {
        this.setDexterity(this.getDexterity() * 2);
        this.setIntelligence(this.getIntelligence() * 2);
        this.setStrength(this.getStrength() * 2);
        this.setLevel(this.getLevel() + 1);
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(),
                        this.getDexterity(), this.getIntelligence(), this.getGold()));

        return sb.toString();
    }
}
