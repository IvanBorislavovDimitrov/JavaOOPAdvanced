package library.io.impl;

import library.io.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderImpl implements InputReader {

    private BufferedReader input;

    public InputReaderImpl() {
        this.input = new BufferedReader(new InputStreamReader(System.in));
    }

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
