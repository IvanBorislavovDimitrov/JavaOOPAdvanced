package hell.commands;

import hell.container.Container;
import hell.factories.RecipeFactory;
import hell.interfaces.Hero;
import hell.interfaces.Recipe;

import java.util.Arrays;

public class RecipeCommand implements Command {

    @Override
    public String execute(Container container, String... params) {
        String type = params[0];
        String itemName = params[1];
        String heroName = params[2];
        int strengthBonus =Integer.parseInt(params[3]);
        int agilityBonus = Integer.parseInt(params[4]);
        int intelligenceBonus = Integer.parseInt(params[5]);
        int hitPointsBonus = Integer.parseInt(params[6]);
        int damageBonus =Integer.parseInt(params[7]);
        String[] requiredItems = Arrays.stream(params).skip(8).toArray(String[]::new);

        Recipe recipe = RecipeFactory.create(type, itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus,requiredItems);

        Hero hero = container.getHero(heroName);

        hero.addRecipe(recipe);

        return String.format("Added recipe - %s to Hero - %s", itemName, heroName);
    }
}
