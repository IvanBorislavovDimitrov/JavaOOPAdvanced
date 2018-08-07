package hell.commands;

import hell.container.Container;
import hell.factories.ItemFactory;
import hell.interfaces.Hero;
import hell.interfaces.Item;

public class ItemCommand implements Command {

    @Override
    public String execute(Container container, String... params) {
        String type = params[0];
        String itemName = params[1];
        String heroName = params[2];
        int strengthBonus = Integer.parseInt(params[3]);
        int agilityBonus = Integer.parseInt(params[4]);
        int intelligenceBonus = Integer.parseInt(params[5]);
        int hitPointsBonus = Integer.parseInt(params[6]);
        int damageBonus = Integer.parseInt(params[7]);

        Item item = ItemFactory.create(type, itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);

        Hero hero = container.getHero(heroName);
        hero.addItem(item);

        return String.format("Added item - %s to Hero - %s", itemName, heroName);
    }
}
