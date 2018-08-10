package panzer.factories;

import panzer.contracts.Part;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public final class PartFactory {

    private PartFactory() {

    }

    public static Part create(String type, String model, double weight, BigDecimal price, int additionParameter) {
        try {
            return (Part) Class.forName("panzer.models.parts." + type + "Part").getDeclaredConstructor(String.class, double.class, BigDecimal.class, int.class).newInstance(model, weight, price, additionParameter);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
