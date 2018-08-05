package app;

import app.engine.Engine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Engine engine= new Engine();

        engine.run();
    }
}
