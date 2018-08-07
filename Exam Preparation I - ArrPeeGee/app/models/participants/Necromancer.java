package app.models.participants;

import app.abilities.Ability;
import app.abilities.Heal;
import app.abilities.Swiftness;
import app.abilities.Toughness;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.BaseHero;

public class Necromancer extends BaseHero {

    public Necromancer() {
        this.setStrength(Config.NECROMANCER_BASE_STRENGTH);
        this.setDexterity(Config.NECROMANCER_BASE_DEXTERITY);
        this.setIntelligence(Config.NECROMANCER_BASE_INTELLIGENCE);
        this.setGold(Config.HERO_START_GOLD);
    }


    @Override
    public double getDamage() {
        return (this.getIntelligence() * 2) + (this.getDexterity() * 2) + (this.getStrength() * 2);
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
}
