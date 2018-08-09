package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Wizard extends BaseHero {

    public Wizard(String name) {
        super(name,Config.WIZARD_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER,
                Config.HERO_START_GOLD, 1, Config.WIZARD_BASE_STRENGTH, Config.WIZARD_BASE_DEXTERITY,
                Config.WIZARD_BASE_INTELLIGENCE);
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

    @Override
    public double getDamage() {
        return (super.getIntelligence() * 5) + super.getDexterity();
    }
}
