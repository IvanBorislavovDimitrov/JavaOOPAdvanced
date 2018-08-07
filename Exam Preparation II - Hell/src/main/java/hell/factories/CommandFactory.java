package hell.factories;

import hell.commands.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class CommandFactory {

    private static final String PATH = "hell.commands.";

    private CommandFactory() {
    }

    @SuppressWarnings("unchecked")
    public static Command create(String name) {
        try {
            Class<Command> commandClass = (Class<Command>) Class.forName(PATH + name + "Command");
            Constructor<Command> constructor = commandClass.getDeclaredConstructor();

            Command command = constructor.newInstance();

            return command;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
