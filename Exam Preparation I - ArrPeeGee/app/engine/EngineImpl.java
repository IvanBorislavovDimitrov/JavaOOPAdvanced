package app.engine;

import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;
import app.contracts.Writer;
import app.core.BattlefieldImplementation;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {

    private Reader reader;
    private Writer writer;
    private Battlefield battleField;

    public EngineImpl(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
        this.battleField = new BattlefieldImplementation(writer);
    }

    @Override
    public void run() throws IOException {

        String line = reader.readLine();
        while (!line.equals("Peace")) {
            String[] lineTokens = line.split("\\s+");

            switch (lineTokens[0]) {
                case "CreateParticipant":
                    battleField.createParticipant(lineTokens[1], lineTokens[2]);
                    break;
                case "CreateAction":
                    battleField.createAction(lineTokens[1],
                            Arrays.copyOf(Arrays.stream(lineTokens).skip(2).toArray(),
                                    Arrays.stream(lineTokens).skip(2).toArray().length,
                                    String[].class));
                    break;
                case "CreateSpecial":
                    this.battleField.createSpecial(lineTokens[1], lineTokens[2]);
                    break;
                case "StatParticipants":
                    this.battleField.reportParticipants();
                    break;
                case "StatActions":
                    this.battleField.reportActions();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }

            line = reader.readLine();
        }
    }
}
