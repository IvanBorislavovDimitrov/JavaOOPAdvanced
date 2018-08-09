package app.waste_disposal.factories;

import app.waste_disposal.commands.Command;
import app.waste_disposal.contracts.GarbageDisposalStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class StrategyFactory {

    private static final String PATH = "app.waste_disposal.strategies.";

    private StrategyFactory() {

    }

    public static GarbageDisposalStrategy create(String type) {
        try {
            Class<GarbageDisposalStrategy> commandClass = (Class<GarbageDisposalStrategy>) Class.forName(PATH + type + "Strategy");
            Constructor<GarbageDisposalStrategy> commandConstructor = commandClass.getDeclaredConstructor();
            GarbageDisposalStrategy garbageDisposalStrategy = commandConstructor.newInstance();

            return garbageDisposalStrategy;
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
