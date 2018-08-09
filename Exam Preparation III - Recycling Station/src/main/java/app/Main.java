package app;

import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.container.WasteContainer;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.InputReader;
import app.waste_disposal.contracts.OutputWriter;
import app.waste_disposal.engine.Engine;
import app.waste_disposal.io.ConsoleReader;
import app.waste_disposal.io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {

        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor();
        InputReader inputReader = new ConsoleReader();
        OutputWriter outputWriter = new ConsoleWriter();
        WasteContainer wasteContainer = new WasteContainer();

        Engine engine = new Engine(garbageProcessor, inputReader, outputWriter, wasteContainer);

        engine.run();
    }
}
