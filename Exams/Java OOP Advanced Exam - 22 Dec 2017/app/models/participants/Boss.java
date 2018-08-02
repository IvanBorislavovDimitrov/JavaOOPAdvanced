package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss extends BaseTargetable {

    private double individualReward;

    public Boss() {
        this.setHealth(Config.BOSS_HEALTH);
        this.setGold(Config.BOSS_GOLD);
        this.individualReward = Config.BOSS_INDIVIDUAL_REWARD;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
    }

    @Override
    public double getDamage() {
        return Config.BOSS_DAMAGE;
    }

    @Override
    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
        this.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.getGold());
        this.setGold(this.getGold() * 0.9);
    }

    public double getIndividualReward() {
        return individualReward;
    }

    public void setIndividualReward(double individualReward) {
        this.individualReward = individualReward;
    }
}
