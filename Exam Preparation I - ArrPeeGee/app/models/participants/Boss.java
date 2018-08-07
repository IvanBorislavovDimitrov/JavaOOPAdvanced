package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.BaseHero;

public class Boss extends BaseHero implements Targetable {

    public Boss() {
        this.setHealth(Config.BOSS_HEALTH);
        this.setGold(Config.BOSS_GOLD);
    }

    @Override
    public double getDamage() {
        return Config.BOSS_DAMAGE;
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
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }


    @Override
    public void levelUp() {
        this.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public void receiveReward(double reward) {
        super.receiveReward(reward * 0.1);
    }
}
