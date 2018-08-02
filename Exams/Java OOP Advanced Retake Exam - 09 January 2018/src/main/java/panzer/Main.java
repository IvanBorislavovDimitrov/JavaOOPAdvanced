package panzer;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.engine.Engine;
import panzer.io.Reader;
import panzer.io.Writer;
import panzer.manager.ManagerImpl;

public class Main {

    public static void main(String[] args) {
        InputReader inputReader = new Reader();
        OutputWriter outputWriter = new Writer();
        Manager manager = new ManagerImpl();

        Engine engine = new Engine(inputReader, outputWriter, manager);

        engine.run();
    }
}
