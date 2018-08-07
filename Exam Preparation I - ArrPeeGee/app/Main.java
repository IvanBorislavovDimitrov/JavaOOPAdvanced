package app;

import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;
import app.contracts.Writer;
import app.core.BattlefieldImplementation;
import app.engine.EngineImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        Engine engine = new EngineImpl(reader, writer);

        engine.run();
    }
}
