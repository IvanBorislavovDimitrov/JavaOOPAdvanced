package src.io;

public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(Object obj) {
        System.out.println(obj);
    }
}
