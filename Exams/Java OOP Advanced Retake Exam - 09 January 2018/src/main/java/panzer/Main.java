package panzer;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.engine.Engine;
import panzer.io.ConsoleReader;
import panzer.io.ConsoleWriter;
import panzer.manager.ManagerImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        InputReader inputReader = new ConsoleReader();
        OutputWriter outputWriter = new ConsoleWriter();
        Manager manager = new ManagerImpl();

        Engine engine = new Engine(inputReader, outputWriter, manager);

        engine.run();
    }
}
