package app.waste_disposal.factories;

import app.waste_disposal.commands.Command;
import app.waste_disposal.container.WasteContainer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class CommandFactory {

    private static final String PATH = "app.waste_disposal.commands.";

    private CommandFactory() {

    }

    public static Command create(String type) {
        try {
            Class<Command> commandClass = (Class<Command>) Class.forName(PATH + type + "Command");
            Constructor<Command> commandConstructor = commandClass.getDeclaredConstructor();
            Command command = commandConstructor.newInstance();

            return command;
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
