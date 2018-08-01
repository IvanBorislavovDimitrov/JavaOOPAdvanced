package src;

import src.Core.CommandHandlerImpl;
import src.Core.Engine;
import src.contracts.BoatSimulatorController;
import src.controllers.BoatSimulatorControllerImpl;
import src.io.ConsoleReader;
import src.io.ConsoleWriter;
import src.io.Reader;
import src.io.Writer;

public class Main {
    public static void main(String[] args) {
        BoatSimulatorController boatSimulatorController = new BoatSimulatorControllerImpl();
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        CommandHandlerImpl commandHandler = new CommandHandlerImpl(boatSimulatorController);
        Engine engine = new Engine(commandHandler, reader, writer);

        engine.run();
    }
}
