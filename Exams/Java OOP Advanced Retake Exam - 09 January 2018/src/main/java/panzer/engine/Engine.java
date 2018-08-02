package panzer.engine;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class Engine {

    private static final String TERMINATE_COMMAND = "Terminate";

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Manager manager;

    public Engine(InputReader inputReader, OutputWriter outputWriter, Manager manager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.manager = manager;
    }

    public void run() {
        String line;
        while (!(line = inputReader.readLine().trim()).equals(TERMINATE_COMMAND)) {
            executeCommand(line);
        }

        String log = this.manager.terminate(null);
        this.outputWriter.println(log);
    }

    private void executeCommand(String line) {
        String[] tokens = line.split("\\s+");
        String command = tokens[0];
        switch (command) {
            case "Vehicle":
                List<String> arguments = new ArrayList<>() {{
                    add(tokens[1]);
                    add(tokens[2]);
                    add(tokens[3]);
                    add(tokens[4]);
                    add(tokens[5]);
                    add(tokens[6]);
                    add(tokens[7]);
                }};
                String log = this.manager.addVehicle(arguments);
                this.outputWriter.println(log);
                break;
            case "Part":
                arguments = new ArrayList<>() {{
                    add(tokens[1]);
                    add(tokens[2]);
                    add(tokens[3]);
                    add(tokens[4]);
                    add(tokens[5]);
                    add(tokens[6]);
                }};
                log = this.manager.addPart(arguments);
                this.outputWriter.println(log);
                break;
            case "Inspect":
                arguments = new ArrayList<>() {{
                    add(tokens[1]);
                }};
                log = this.manager.inspect(arguments);
                this.outputWriter.println(log);
                break;
            case "Battle":
                arguments = new ArrayList<>() {{
                    add(tokens[1]);
                    add(tokens[2]);
                }};
                log = this.manager.battle(arguments);
                this.outputWriter.println(log);
                break;
        }
    }
}
