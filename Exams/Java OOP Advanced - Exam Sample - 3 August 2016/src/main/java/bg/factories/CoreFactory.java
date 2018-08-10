package bg.factories;

import bg.contracts.Core;

import java.lang.reflect.InvocationTargetException;

public final class CoreFactory {

    private CoreFactory() {

    }

    public static Core create(String type, Integer durability) {
        try {
            return (Core) Class.forName("bg.softuni.models.models.cores." + type  + "Core").getDeclaredConstructor(String .class, Integer.class).newInstance(type, durability);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            throw new IllegalArgumentException("Failed to create Core!");
        }
    }
}
