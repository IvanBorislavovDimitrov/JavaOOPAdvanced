package src.factories;

import src.annotations.Inject;
import src.command.interfaces.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class CommandFactory {

    private static final String PATH = "src.command.impl.";

    private CommandFactory() {
    }

    @SuppressWarnings("unchecked")
    public static Command createCommand(String name, Object... args) {
        try {
            Class<Command> commandClass = (Class<Command>) Class.forName(PATH + name + "Command");
            Constructor<Command> constructorWithoutParams = commandClass.getDeclaredConstructor();
            Command command = constructorWithoutParams.newInstance();

            int index = 0;
            Field[] fields = command.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(Inject.class)) {
                    field.set(command, args[index++]);
                }
            }

            return command;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
