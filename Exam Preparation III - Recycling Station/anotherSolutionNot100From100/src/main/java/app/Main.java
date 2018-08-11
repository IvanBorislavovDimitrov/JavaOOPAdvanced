package app;

import app.engine.Engine;
import app.engine.EngineImpl;
import app.factories.GarbageFactory;
import app.factories.StrategyFactory;
import app.injector.Injector;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;
import app.io.InputReader;
import app.io.OutputWriter;
import app.manager.GarbageManager;
import app.manager.Manager;
import app.object_conatiner.Container;
import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.contracts.GarbageProcessor;

public class Main {

    public static void main(String[] args) throws Exception {

        InputReader inputReader = new ConsoleReader();
        OutputWriter outputWriter = new ConsoleWriter();
        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor();
        Manager manager = new GarbageManager();
        GarbageFactory garbageFactory = new GarbageFactory();
        StrategyFactory strategyFactory = new StrategyFactory();

        Container container = new Container(inputReader, outputWriter, garbageProcessor, garbageFactory, manager, strategyFactory);

        Engine engine = new EngineImpl();

        Injector.inject(container, manager);
        Injector.inject(container, engine);

        engine.run();
    }
}
