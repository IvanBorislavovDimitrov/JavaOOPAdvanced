package app.abilities;


public class Heal extends Ability {

    @Override
    public void gain() {
        if (this.getHero().getHealth() <= this.getStartHealth() * 0.5) {
            this.getHero().setHealth(this.getHero().getHealth() + this.getHero().getIntelligence());
        }
    }
}
