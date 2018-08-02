package panzer.factories;

import panzer.contracts.Vehicle;
import panzer.entities.vehicles.AbstractVehicle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public final class VehicleFactory {

    private VehicleFactory() {
    }

    private static final String VEHICLES_PATH = "panzer.entities.vehicles.";

    public static Vehicle createVehicle(String type, String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        try {
            Class<? extends AbstractVehicle> clazz = (Class<? extends AbstractVehicle>) Class.forName(VEHICLES_PATH + type);

            Constructor<? extends AbstractVehicle> declaredConstructor = clazz.getDeclaredConstructor(String.class, double.class, BigDecimal.class, int.class, int.class, int.class);

            AbstractVehicle baseVehicle = declaredConstructor.newInstance(model, weight, price, attack, defense, hitPoints);

            return baseVehicle;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("Invalid vehicle type!");
    }
}
