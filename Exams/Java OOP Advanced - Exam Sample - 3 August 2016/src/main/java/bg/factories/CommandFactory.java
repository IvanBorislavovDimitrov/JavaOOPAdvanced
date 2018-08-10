package bg.factories;

import bg.commands.Command;

import java.lang.reflect.InvocationTargetException;

public final class CommandFactory {

    private CommandFactory() {

    }

    public static Command create(String name) {
        try {
            return (Command) Class.forName("bg.commands." + name + "Command").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            throw new IllegalArgumentException("Failed to create Command!");
        }

    }
}
