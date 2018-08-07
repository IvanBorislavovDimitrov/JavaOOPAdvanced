package hell.engine;

import hell.commands.Command;
import hell.container.Container;
import hell.executor.CommandExecutor;
import hell.factories.CommandFactory;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;

public class Engine {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private CommandExecutor commandExecutor;
    private Container container;

    public Engine(InputReader inputReader, OutputWriter outputWriter, CommandExecutor commandExecutor, Container container) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.commandExecutor = commandExecutor;
        this.container = container;
    }

    public void run() {
        String line = this.inputReader.readLine();
        while (true) {
            String[] tokens = line.split("\\s+");
            String commandName = tokens[0];
            Command command = CommandFactory.create(commandName);
            String log = this.commandExecutor.execute(this.container, command, tokens);

            this.outputWriter.writeLine(log);

            if ("Quit".equals(line)) {
                break;
            }

            line = inputReader.readLine();
        }
    }
}
