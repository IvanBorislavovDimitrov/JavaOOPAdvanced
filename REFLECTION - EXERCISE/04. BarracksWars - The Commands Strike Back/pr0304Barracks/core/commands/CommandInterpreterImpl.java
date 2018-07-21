package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.CommandInterpreter;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String PATH = "pr0304Barracks.core.commands.";

    private final Repository repository;
    private final UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String validCommand = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
        try {
            Class<?> clazz = Class.forName(PATH + validCommand + "Command");
            Executable executable = (Executable) clazz
                    .getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class)
                    .newInstance(data, this.repository, this.unitFactory);

            return executable;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
