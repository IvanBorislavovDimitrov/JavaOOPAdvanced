package hell.factories;

import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class RecipeFactory {

    private static final String PATH = "hell.entities.models.items.";

    private RecipeFactory() {

    }

    @SuppressWarnings("unchecked")
    public static Recipe create(String type, String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, String... requiredItems) {
        try {
            Class<Recipe> itemClass = (Class<Recipe>) Class.forName(PATH + type + "Item");
            Constructor<Recipe> constructor = itemClass.getDeclaredConstructor(String.class, int.class,  int.class, int.class, int.class, int.class);

            Recipe recipe = constructor.newInstance(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);

            recipe.getRequiredItems().addAll(Arrays.asList(requiredItems));

            return recipe;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
