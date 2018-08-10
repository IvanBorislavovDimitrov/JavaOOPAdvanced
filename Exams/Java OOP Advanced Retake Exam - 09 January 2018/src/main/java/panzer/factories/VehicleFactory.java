package panzer.factories;

import panzer.contracts.Assembler;
import panzer.contracts.Vehicle;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public final class VehicleFactory {

    private VehicleFactory() {

    }

    public static Vehicle createVehicle(String type, String model, double weight, BigDecimal price, long attack, long defence, long hitPoints, Assembler assembler) {
        try {
            return (Vehicle) Class.forName("panzer.models.vehicles." + type)
                    .getDeclaredConstructor(String.class, double.class, BigDecimal.class, long.class, long.class, long.class, Assembler.class).newInstance(model, weight, price, attack, defence, hitPoints, assembler);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("Obarkah sa vav factoryto Vehicle");
    }
}
