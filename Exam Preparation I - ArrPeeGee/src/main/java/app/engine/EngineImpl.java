package app.engine;

import app.commands.Command;
import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class EngineImpl implements Engine {

    private Reader reader;
    private Battlefield battleField;

    public EngineImpl(Reader reader, Battlefield battlefield) {
        this.reader = reader;
        this.battleField = battlefield;
    }

    @Override
    public void run() throws IOException {

        String line = reader.readLine();
        while (!line.equals("Peace")) {
            String[] lineTokens = line.split("\\s+");

            try {
                Command command = (Command) Class.forName("app.commands." + lineTokens[0]).getDeclaredConstructor().newInstance();
                command.execute(this.battleField, lineTokens);
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                System.out.println("Invalid command!");
            }

            line = reader.readLine();
        }
    }
}
