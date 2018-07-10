import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int inputLinesCount = Integer.parseInt(input.readLine());
        GenericBox<String> genericBox = new GenericBox<>();
        for (int i = 0; i < inputLinesCount; i++) {
            genericBox.getValues().add(input.readLine());
        }

        System.out.println(genericBox.countOfElementsBiggerThan(input.readLine()));
    }
}
