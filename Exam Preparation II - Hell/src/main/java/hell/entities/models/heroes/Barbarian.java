package hell.entities.models.heroes;

import hell.utilities.Config;

public class Barbarian extends BaseHero {

    public Barbarian(String name) {
        super(
                name,
                Config.BARBARIAN_DEFAULT_STRENGTH,
                Config.BARBARIAN_DEFAULT_AGILITY,
                Config.BARBARIAN_DEFAULT_INTELLIGENCE,
                Config.BARBARIAN_DEFAULT_HIT_POINTS,
                Config.BARBARIAN_DEFAULT_DAMAGE
        );
    }


}
