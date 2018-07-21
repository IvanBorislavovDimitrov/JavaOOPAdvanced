package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.models.units.*;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "pr0304Barracks.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        switch (unitType) {
            case "Swordsman":
                try {
                    return Swordsman.class.getDeclaredConstructor().newInstance();
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                    return null;
                }
            case "Archer":
                try {
                    return Archer.class.getDeclaredConstructor().newInstance();
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                    return null;
                }
            case "Pikeman":
                try {
                    return Pikeman.class.getDeclaredConstructor().newInstance();
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                    return null;
                }
            case "Horseman":
                try {
                    return Horseman.class.getDeclaredConstructor().newInstance();
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                    return null;
                }
            case "Gunner":
                try {
                    return Gunner.class.getDeclaredConstructor().newInstance();
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                    return null;
                }
        }

        return null;
    }
}
