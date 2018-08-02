package cresla;

import cresla.engine.Engine;
import cresla.interfaces.InputReader;
import cresla.interfaces.OutputWriter;
import cresla.io.ConsoleReader;
import cresla.io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {
        InputReader inputReader = new ConsoleReader();
        OutputWriter outputWriter = new ConsoleWriter();
        Engine engine = new Engine(inputReader, outputWriter);

        engine.run();
    }
}
