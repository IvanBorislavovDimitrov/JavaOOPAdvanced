package app.waste_disposal.io;

import app.waste_disposal.contracts.OutputWriter;

public class ConsoleWriter implements OutputWriter {


    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
