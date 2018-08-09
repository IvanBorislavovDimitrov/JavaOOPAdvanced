package bg.softuni.io;

import bg.softuni.contracts.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void writeLine(Object o) {
        System.out.println(o);
    }
}
