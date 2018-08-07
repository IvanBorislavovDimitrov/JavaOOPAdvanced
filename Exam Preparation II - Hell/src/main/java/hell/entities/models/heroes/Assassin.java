package hell.entities.models.heroes;

import hell.utilities.Config;

public class Assassin extends BaseHero {

    public Assassin(String name) {
        super(
                name,
                Config.ASSASSIN_DEFAULT_STRENGTH,
                Config.ASSASSIN_DEFAULT_AGILITY,
                Config.ASSASSIN_DEFAULT_INTELLIGENCE,
                Config.ASSASSIN_DEFAULT_HIT_POINTS,
                Config.ASSASSIN_DEFAULT_DAMAGE
        );
    }
}
