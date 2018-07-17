import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String importanceStr = input.readLine();
        Importance importance = Enum.valueOf(Importance.class, importanceStr);
        Logger logger = new Logger(importance);
        String line;
        while (!"END".equals(line = input.readLine())) {
            String[] lineInfo = line.split("[: ]+");
            Importance currentImportance = Enum.valueOf(Importance.class, lineInfo[0]);
            String text = Arrays.stream(lineInfo).skip(1).collect(Collectors.joining(" "));
            Message message = new Message(currentImportance, text);
            logger.receiveMessage(message);
        }

        logger.getMessages().forEach(System.out::println);
    }
}
