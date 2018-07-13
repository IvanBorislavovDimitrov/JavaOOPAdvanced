import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        ListyIterator listyIterator = new ListyIterator(Arrays.stream(line.split("\\s+")).skip(1).toArray(String[]::new));
        while (!"END".equals(line = input.readLine())) {
            switch (line) {
                case "Print":
                    listyIterator.print();
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }
        }
    }

}
