package bg.engine;

import bg.commands.Command;
import bg.contracts.Engine;
import bg.contracts.InputReader;
import bg.contracts.Manager;
import bg.contracts.OutputWriter;
import bg.factories.CommandFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class EngineImpl implements Engine {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Manager manager;

    public EngineImpl(InputReader inputReader, OutputWriter outputWriter, Manager manager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            String line = inputReader.readLine();
            String[] tokens = line.split("\\:");
            String commandName = tokens[0];
            if ("System Shutdown!".equalsIgnoreCase(commandName)) {
                break;
            }

            try {
                Command command = CommandFactory.create(commandName);
                String[] otherTokens = tokens.length == 2 ?
                        Arrays.stream(tokens[1].split("@")).skip(1).toArray(String[]::new) : null;
                String log = command.execute(manager, otherTokens);

                outputWriter.writeLine(log);
            } catch (IllegalArgumentException e) {
                outputWriter.writeLine(e.getMessage());

            }


        }
    }
}
