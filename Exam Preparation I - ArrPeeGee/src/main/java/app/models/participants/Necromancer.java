package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Necromancer extends BaseHero {

    public Necromancer(String name) {
        super(name,Config.NECROMANCER_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER,
                Config.HERO_START_GOLD, 1, Config.NECROMANCER_BASE_STRENGTH, Config.NECROMANCER_BASE_DEXTERITY,
                Config.NECROMANCER_BASE_INTELLIGENCE);
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
        if (this.getAbility() != null)
            this.getAbility().gain();

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
        return (super.getIntelligence() * 2) + (super.getDexterity() * 2) + (super.getStrength() * 2);
    }
}
