package app.waste_disposal.factories;

import app.waste_disposal.commands.Command;
import app.waste_disposal.contracts.Waste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class WasteFactory {

    private static final String PATH = "app.waste_disposal.models.";

    private WasteFactory() {
    }

    public  static Waste create(String type, String name, double weight, double volumePerKg) {
        try {
            Class<Waste> commandClass = (Class<Waste>) Class.forName(PATH + type + "Garbage");
            Constructor<Waste> commandConstructor = commandClass.getDeclaredConstructor(String.class, double.class, double.class);
            Waste waste = commandConstructor.newInstance(name, weight, volumePerKg);

            return waste;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return null;
    }
}
