package app.models.participants;

import app.models.Config;

public class Necromancer extends BaseHero {

    public Necromancer() {
        super();
        super.setStrength(Config.NECROMANCER_BASE_STRENGTH);
        super.setDexterity(Config.NECROMANCER_BASE_DEXTERITY);
        super.setIntelligence(Config.NECROMANCER_BASE_INTELLIGENCE);
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * 2) + (super.getDexterity() * 2) + (super.getStrength() * 2);
    }
}
