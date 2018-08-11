package app.factories;

import app.waste_disposal.contracts.GarbageDisposalStrategy;

import java.lang.reflect.InvocationTargetException;

public final class StrategyFactory {

    private static final String PATH = "app.waste_disposal.strategies.";

    public GarbageDisposalStrategy create(String type) {
        try {
            return (GarbageDisposalStrategy) Class.forName(PATH + type + "GarbageStrategy").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
