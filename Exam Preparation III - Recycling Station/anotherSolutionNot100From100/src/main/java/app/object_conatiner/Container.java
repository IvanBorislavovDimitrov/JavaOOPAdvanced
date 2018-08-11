package app.object_conatiner;

import app.factories.GarbageFactory;
import app.factories.StrategyFactory;
import app.io.InputReader;
import app.io.OutputWriter;
import app.manager.Manager;
import app.waste_disposal.contracts.GarbageProcessor;

public final class Container {

    private InputReader inputReader;

    private OutputWriter outputWriter;

    private GarbageProcessor garbageProcessor;

    private GarbageFactory garbageFactory;

    private Manager manager;

    private StrategyFactory strategyFactory;


    public Container(InputReader inputReader, OutputWriter outputWriter, GarbageProcessor garbageProcessor, GarbageFactory garbageFactory, Manager manager, StrategyFactory strategyFactory) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.garbageProcessor = garbageProcessor;
        this.garbageFactory = garbageFactory;
        this.manager = manager;
        this.strategyFactory = strategyFactory;
    }

}
