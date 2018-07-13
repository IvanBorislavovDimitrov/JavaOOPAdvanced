import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!"END".equals(line = input.readLine())) {
            int[] arr = Arrays.stream(line.split(", | ")).mapToInt(Integer::parseInt).toArray();
            Lake lake = new Lake(arr);
            StringBuilder sb = new StringBuilder();
            for (Integer integer : lake) {
                sb.append(integer).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            System.out.println(sb);
        }
    }
}
