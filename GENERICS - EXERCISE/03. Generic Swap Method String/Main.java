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
        List<GenericBox<String>> list = new ArrayList<>();
        for (int i = 0; i < inputLinesCount; i++) {
            list.add(new GenericBox<>(input.readLine()));
        }

        int[] swapVars = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int first = swapVars[0];
        int second = swapVars[1];

        GenericBox<String> swapVar = list.get(first);
        list.set(first, list.get(second));
        list.set(second, swapVar);

        list.forEach(System.out::println);
    }
}
