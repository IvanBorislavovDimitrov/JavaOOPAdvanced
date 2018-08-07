package hell.commands;

import hell.container.Container;
import hell.factories.HeroFactory;
import hell.interfaces.Hero;

public class HeroCommand implements Command {

    @Override
    public String execute(Container container, String... params) {
        String heroName = params[1];
        String heroType = params[2];

        Hero hero = HeroFactory.create(heroType, heroName);

        container.addHero(hero);

        return String.format("Created %s - %s", heroType, heroName);
    }
}
