package bg.io;

import bg.contracts.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements InputReader {

    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String readLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
