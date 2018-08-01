package src.Core;

import src.contracts.CommandHandler;
import src.io.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {

    private CommandHandler commandHandler;
    private Reader reader;
    private Writer writer;

    public Engine(CommandHandlerImpl commandHandler, Reader reader, Writer writer) {
        this.commandHandler = commandHandler;
        this.reader = reader;
        this.writer = writer;
    }

    public void run() {
        while (true) {
            String line = this.reader.readLine();
            String name;
            List<String> parameters;

            if (line.equals("End")) {
                break;
            }

            List<String> tokens = Arrays.asList(line.split("\\\\"));
            name = tokens.get(0);
            parameters = tokens.stream().skip(1).collect(Collectors.toList());

            try {
                String commandResult = this.commandHandler.executeCommand(name, parameters);
                this.writer.writeLine(commandResult);
            } catch (Throwable ex) {
                this.writer.writeLine(ex.getMessage());
            }

        }
    }
}
