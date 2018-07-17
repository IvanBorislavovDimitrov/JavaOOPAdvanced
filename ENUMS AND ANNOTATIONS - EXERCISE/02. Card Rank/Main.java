import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        System.out.println(line + ":");
        for (Card suit : Card.values()) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", suit.ordinal(), suit.name()));
        }
    }
}
