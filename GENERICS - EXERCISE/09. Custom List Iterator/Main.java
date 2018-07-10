import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> list = new CustomList<>();
        String line;
        while (!"END".equals(line = input.readLine())) {
            String[] info = line.split("\\s+");
            String command = info[0];
            switch (command) {
                case "Add":
                    list.add(info[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(info[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(info[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(info[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Sort":
                    Sort.sort(list);
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.forEach(System.out::println);
                    break;
            }
        }
    }
}
