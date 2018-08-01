package src.p01_system_resources.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderImpl implements Reader {

    private BufferedReader bufferedReader;

    public ReaderImpl() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        try {
            return this.bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
