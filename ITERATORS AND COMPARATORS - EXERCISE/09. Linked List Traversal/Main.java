import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        MyList<Integer> list = new MyLinkedList<>();

        int commandsCount = Integer.parseInt(input.readLine());

        for (int i = 0; i < commandsCount; i++) {
            String[] commandInfo = input.readLine().split("\\s+");
            String command = commandInfo[0];
            int number = Integer.parseInt(commandInfo[1]);

            switch (command) {
                case "Add":
                    list.add(number);
                    break;
                case "Remove":
                    list.remove(number);
                    break;
            }
        }

        System.out.println(list.getSize());

        for (Integer integer : list) {
            System.out.printf("%d ", integer);
        }
    }
}
