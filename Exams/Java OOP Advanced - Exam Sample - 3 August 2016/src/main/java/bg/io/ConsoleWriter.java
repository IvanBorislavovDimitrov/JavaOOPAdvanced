package bg.io;

import bg.contracts.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
