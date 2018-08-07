package app.models.participants;

import app.abilities.Swiftness;
import app.abilities.Toughness;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.BaseHero;

public class Wizard extends BaseHero {

    public Wizard() {
        this.setStrength(Config.WIZARD_BASE_STRENGTH);
        this.setDexterity(Config.WIZARD_BASE_DEXTERITY);
        this.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
        this.setGold(Config.HERO_START_GOLD);
    }

    @Override
    public double getDamage() {
        return (this.getIntelligence() * 5) + this.getDexterity();
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()) {
            return target.getName() + " is dead! Cannot be attacked.";
        }

        if (this.getAbility() != null) {
            this.getAbility().gain();
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
}
