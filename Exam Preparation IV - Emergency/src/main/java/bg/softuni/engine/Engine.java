package bg.softuni.engine;

import bg.softuni.commands.Command;
import bg.softuni.contracts.InputReader;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.contracts.OutputWriter;
import bg.softuni.core.EmergencyManagementSystem;

import java.util.Arrays;

public class Engine {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private ManagementSystem managementSystem;

    public Engine(InputReader inputReader, OutputWriter outputWriter, ManagementSystem managementSystem) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.managementSystem = managementSystem;
    }

    public void run() throws Exception {
        String line;
        while (!"EmergencyBreak".equals(line = inputReader.readLine())) {
            String[] tokens = line.split("\\|");
            String commandName = tokens[0];
            Command command = (Command) Class.forName("bg.softuni.commands." + commandName + "Command").getDeclaredConstructor().newInstance();
            String log = command.execute(this.managementSystem, Arrays.stream(tokens).skip(1).toArray(String[]::new));

            this.outputWriter.writeLine(log);
        }
    }
}
