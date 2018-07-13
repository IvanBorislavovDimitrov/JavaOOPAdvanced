import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Stack stack = new Stack();
        while (!"END".equalsIgnoreCase(line = input.readLine())) {
            String[] lineInfo = line.split("[ ,]+");
            String command = lineInfo[0];
            lineInfo = Arrays.stream(lineInfo)
                    .skip(1)
                    .toArray(String[]::new);
            switch (command) {
                case "Push":
                    Arrays.stream(lineInfo)
                            .mapToInt(Integer::parseInt)
                            .forEach(stack::push);
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        for (Integer integer : stack) {
            System.out.println(integer);
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
