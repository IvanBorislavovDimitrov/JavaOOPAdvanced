package bg;

import bg.contracts.Engine;
import bg.contracts.InputReader;
import bg.contracts.Manager;
import bg.contracts.OutputWriter;
import bg.engine.EngineImpl;
import bg.io.ConsoleReader;
import bg.io.ConsoleWriter;
import bg.manager.ManagerImpl;

public class Main {

    public static void main(String[] args) {
        OutputWriter outputWriter = new ConsoleWriter();
        InputReader inputReader = new ConsoleReader();
        Manager manager = new ManagerImpl();

        Engine engine = new EngineImpl(inputReader, outputWriter, manager);
        engine.run();
    }
}
