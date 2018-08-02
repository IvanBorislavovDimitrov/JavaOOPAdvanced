package app.engine;

import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;
import app.contracts.Writer;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {

    private Battlefield battlefield;
    private Reader reader;

    public EngineImpl(Battlefield battlefield, Reader reader) {
        this.battlefield = battlefield;
        this.reader = reader;
    }

    @Override
    public void run() throws IOException {
        String line;
        while (!(line = this.reader.readLine()).equals("Peace")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "CreateParticipant":
                    this.battlefield.createParticipant(tokens[1], tokens[2]);
                    break;
                case "CreateAction":
                    this.battlefield.createAction(tokens[1],
                            Arrays.stream(tokens).skip(2).toArray(String[]::new));
                    break;
                case "CreateSpecial":
                    this.battlefield.createSpecial(tokens[1], tokens[2]);
                    break;
                case "StatParticipants":
                    this.battlefield.reportParticipants();
                    break;
                case "StatActions":
                    this.battlefield.reportActions();
                    break;
            }
        }
    }
}
