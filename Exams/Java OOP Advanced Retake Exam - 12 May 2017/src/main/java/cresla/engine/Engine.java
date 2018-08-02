package cresla.engine;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.interpreter.CommandInterpreter;
import cresla.manager.ManagerImpl;

public class Engine {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Manager manager;
    private CommandInterpreter commandInterpreter;

    public Engine(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.manager = new ManagerImpl();
        this.commandInterpreter = new CommandInterpreter(this.manager);
    }

    public void run() {
        while (true) {
            String[] args = this.inputReader.readLine().split("\\s+");
            String log = this.commandInterpreter.executeCommand(args);

            this.outputWriter.writeLine(log);
            if ("Exit".equals(args[0])) {
                break;
            }

        }
    }
}
