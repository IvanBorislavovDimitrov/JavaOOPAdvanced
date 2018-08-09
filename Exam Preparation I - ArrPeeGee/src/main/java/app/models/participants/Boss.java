package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss extends BaseTargetable {

    private double individualReward;

    public Boss(String name) {
        super(name, Config.BOSS_HEALTH, Config.BOSS_GOLD, 1);
        this.individualReward = Config.BOSS_INDIVIDUAL_REWARD;
    }

    @Override
    public double getDamage() {
        return Config.BOSS_DAMAGE;
    }

    @Override
    public void levelUp() {
        this.setLevel(this.getLevel() * Config.LEVEL_UP_MULTIPLIER);
        this.setHealth(Config.BOSS_HEALTH);
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
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.getGold());
    }

    @Override
    public void receiveReward(double reward) {
        super.receiveReward(reward * 0.1);
    }

    public double getIndividualReward() {
        return individualReward;
    }

    public void setIndividualReward(double individualReward) {
        this.individualReward = individualReward;
    }
}
