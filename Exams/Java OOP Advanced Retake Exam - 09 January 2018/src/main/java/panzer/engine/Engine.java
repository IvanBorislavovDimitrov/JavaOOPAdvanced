package panzer.engine;

import panzer.commands.Command;
import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;

import java.util.Arrays;

public class Engine {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Manager manager;

    public Engine(InputReader inputReader, OutputWriter outputWriter, Manager manager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.manager = manager;
    }

    public void run() throws Exception {
        while (true) {
            String[] tokens = this.inputReader.readLine().split("\\s+");
            Command command = (Command) Class.forName("panzer.commands." + tokens[0] + "Command")
                    .getDeclaredConstructor().newInstance();

            String log = command.execute(this.manager, Arrays.stream(tokens).skip(1).toArray(String[]::new));

            this.outputWriter.println(log);

            if (tokens[0].equalsIgnoreCase("Terminate")) {
                break;
            }
        }
    }
}
