package panzer.factories;

import panzer.contracts.Part;
import panzer.entities.parts.AbstractPart;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public final class PartFactory {

    private static final String PARTS_PATH = "panzer.entities.parts.";

    private PartFactory() {
    }

    public static Part createPart(String type, String model, double weight, BigDecimal price, int additionalParam) {
        try {
            Class<? extends AbstractPart> clazz = (Class<? extends AbstractPart>) Class.forName(PARTS_PATH + type + "Part");

            Constructor<? extends AbstractPart> declaredConstructor = clazz.getDeclaredConstructor(String.class, double.class, BigDecimal.class, int.class);

            AbstractPart basePart = declaredConstructor.newInstance(model, weight, price, additionalParam);

            return basePart;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("Part does not exist!");
    }
}
