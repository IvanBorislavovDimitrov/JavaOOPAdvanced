package src.p01_system_resources.io;

public class WriterImpl implements Writer {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
