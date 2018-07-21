package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.CommandInterpreter;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String PATH = "pr0304Barracks.core.commands.";

    private String[] data;
    private final Repository repository;
    private final UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory, String[] data) {
        this.repository = repository;
        this.unitFactory = unitFactory;
        this.data = data;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String validCommand = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
        try {
            Class<?> clazz = Class.forName(PATH + validCommand + "Command");
            Executable executable = (Executable) clazz
                    .getDeclaredConstructor()
                    .newInstance();

            this.injectDependencies(executable);

            return executable;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] executableFields = executable.getClass().getDeclaredFields();
        Field[] thisFields = this.getClass().getDeclaredFields();

        for (Field executableField : executableFields) {
            executableField.setAccessible(true);
            if (executableField.isAnnotationPresent(Inject.class)) {
                for (Field thisField : thisFields) {
                    thisField.setAccessible(true);
                    if (thisField.getType().equals(executableField.getType()) &&
                            thisField.getName().equals(executableField.getName())) {
                        executableField.set(executable, thisField.get(this));
                    }
                }
            }
        }
    }
}
