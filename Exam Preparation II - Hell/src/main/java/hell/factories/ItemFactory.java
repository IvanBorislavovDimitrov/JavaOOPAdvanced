package hell.factories;

import hell.interfaces.Item;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class ItemFactory {

    private static final String PATH = "hell.entities.models.items.";

    private ItemFactory() {
    }

    @SuppressWarnings("unchecked")
    public static Item create(String type, String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        try {
            Class<Item> itemClass = (Class<Item>) Class.forName(PATH + type);
            Constructor<Item> constructor = itemClass.getDeclaredConstructor(String.class, int.class,  int.class, int.class, int.class, int.class);

            Item item = constructor.newInstance(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);

            return item;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
