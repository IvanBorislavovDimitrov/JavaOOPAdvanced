package app.models.participants;

import app.abilities.Ability;
import app.abilities.Heal;
import app.abilities.Toughness;
import app.models.Config;
import app.models.participants.BaseHero;

public class Warrior extends BaseHero {

    public Warrior() {
        this.setStrength(Config.WARRIOR_BASE_STRENGTH);
        this.setDexterity(Config.WARRIOR_BASE_DEXTERITY);
        this.setIntelligence(Config.WARRIOR_BASE_INTELLIGENCE);
        this.setGold(Config.HERO_START_GOLD);
    }

    @Override
    public double getDamage() {
        return (this.getStrength() * 2) + this.getDexterity();
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
        if (this.getAbility() != null)
            this.getAbility().gain();
    }
}
