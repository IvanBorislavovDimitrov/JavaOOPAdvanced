package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Dispatcher dispatcher = new Dispatcher("Dispatcher");
        NameChangeListener nameChangeListener = new Handler();
        dispatcher.addNameChangeListener(nameChangeListener);
        while (!"End".equals(line = input.readLine())) {
            NameChange nameChange = new NameChange(line);
            dispatcher.fireNameChangeEvent(nameChange);
        }
    }
}
