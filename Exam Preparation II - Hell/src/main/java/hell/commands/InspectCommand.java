package hell.commands;

import hell.container.Container;
import hell.interfaces.Hero;

public class InspectCommand implements Command {

    @Override
    public String execute(Container container, String... params) {
        String heroName = params[1];

        Hero hero = container.getHero(heroName);

        return hero.toString();
    }
}
