package library.io.impl;

import library.io.interfaces.OutputWriter;

public class OutputWriteImpl implements OutputWriter {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
