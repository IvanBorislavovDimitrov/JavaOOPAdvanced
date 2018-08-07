package hell.entities.models.heroes;

import hell.utilities.Config;

public class Wizard extends BaseHero {

    public Wizard(String name) {
        super(
                name,
                Config.WIZARD_DEFAULT_STRENGTH,
                Config.WIZARD_DEFAULT_AGILITY,
                Config.WIZARD_DEFAULT_INTELLIGENCE,
                Config.WIZARD_DEFAULT_HIT_POINTS,
                Config.WIZARD_DEFAULT_DAMAGE
        );
    }
}
