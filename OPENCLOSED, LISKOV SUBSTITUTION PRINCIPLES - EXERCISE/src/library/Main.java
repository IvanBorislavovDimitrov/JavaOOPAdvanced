package library;

import library.controllers.Controller;
import library.io.impl.InputReaderImpl;
import library.io.interfaces.InputReader;

public class Main {

    public static void main(String[] args) {
        InputReader inputReader = new InputReaderImpl();
        Controller controller = new Controller(inputReader);

        controller.run();
    }
}
