package app.abilities;

import app.contracts.Hero;
import app.models.participants.BaseHero;

public class Toughness extends Ability {

    @Override
    public void gain() {
        if (this.getHero().getHealth() <= this.getStartHealth() * 0.5) {
            this.getHero().setStrength(this.getHero().getStrength() + this.getHero().getIntelligence());
        }
    }
}