package app.abilities;

import app.contracts.Hero;

public class Toughness extends Ability {

    @Override
    public void gain() {
        if (this.getHero().getHealth() <= this.getStartHealth() * 0.5) {
            this.getHero().addStrength(this.getHero().getIntelligence());
        }
    }
}