package app.models.participants;

import app.models.Config;

public class Wizard extends BaseHero {

    public Wizard() {
        super();
        super.setStrength(Config.WIZARD_BASE_STRENGTH);
        super.setDexterity(Config.WIZARD_BASE_DEXTERITY);
        super.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * 5) + super.getDexterity();
    }
}
