package hell;

import hell.container.Container;
import hell.engine.Engine;
import hell.entities.io.ConsoleReader;
import hell.entities.io.ConsoleWriter;
import hell.entities.models.heroes.Barbarian;
import hell.executor.CommandExecutor;
import hell.interfaces.Hero;
import hell.interfaces.InputReader;
import hell.interfaces.Item;
import hell.interfaces.OutputWriter;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutor();
        InputReader inputReader = new ConsoleReader();
        OutputWriter outputWriter = new ConsoleWriter();
        Container container = new Container();
        Engine engine = new Engine(inputReader, outputWriter, commandExecutor, container);

        engine.run();
    }
}