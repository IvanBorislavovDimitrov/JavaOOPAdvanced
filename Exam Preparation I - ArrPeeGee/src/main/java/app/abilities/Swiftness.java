package app.abilities;


public class Swiftness extends Ability {

    @Override
    public void gain() {
        if (this.getHero().getHealth() >= this.getStartHealth() * 0.5) {
            this.getHero().setDexterity(this.getHero().getDexterity() + this.getHero().getIntelligence());
        }
    }
}
