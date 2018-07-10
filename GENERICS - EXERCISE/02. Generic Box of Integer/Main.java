import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int inputLinesCount = Integer.parseInt(input.readLine());
        for (int i = 0; i < inputLinesCount; i++) {
            GenericBox<Integer> genericBox = new GenericBox<>(Integer.parseInt(input.readLine()));
            System.out.println(genericBox);
        }
    }
}
