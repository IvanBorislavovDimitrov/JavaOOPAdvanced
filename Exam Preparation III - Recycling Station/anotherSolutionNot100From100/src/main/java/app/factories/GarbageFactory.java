package app.factories;

import app.waste_disposal.contracts.Waste;

import java.lang.reflect.InvocationTargetException;

public final class GarbageFactory {

    private static final String PATH = "app.models.";

    public Waste create(String name, double weight, double volumePerKg, String type) {
        try {

            return (Waste) Class.forName(PATH + type + "Garbage").getDeclaredConstructor(String.class, double.class, double.class)
                    .newInstance(name, weight, volumePerKg);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
