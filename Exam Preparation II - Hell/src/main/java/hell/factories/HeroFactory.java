package hell.factories;

import hell.interfaces.Hero;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class HeroFactory {

    private static final String PATH = "hell.entities.models.heroes.";

    private HeroFactory() {

    }

    @SuppressWarnings("unchecked")
    public static Hero create(String type, String name) {
        try {
            Class<Hero> heroClass = (Class<Hero>) Class.forName(PATH + type);
            Constructor<Hero> constructor = heroClass.getDeclaredConstructor(String.class);
            Hero hero = constructor.newInstance(name);

            return hero;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
