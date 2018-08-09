package app.models.participants;

import app.models.Config;

public class Warrior extends BaseHero {

    public Warrior() {
        this(null);
    }

    public Warrior(String name) {
        super(name,Config.WARRIOR_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER,
                Config.HERO_START_GOLD, 1, Config.WARRIOR_BASE_STRENGTH, Config.WARRIOR_BASE_DEXTERITY,
                Config.WARRIOR_BASE_INTELLIGENCE);
    }


    @Override
    public void takeDamage(double damage) {
        super.takeDamage(damage);
        if (this.getAbility() != null)
            this.getAbility().gain();
    }

    @Override
    public double getDamage() {
        return (super.getStrength() * 2) + super.getDexterity();
    }
}
