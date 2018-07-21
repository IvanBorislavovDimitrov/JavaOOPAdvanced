import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Field[] fields = RichSoilLand.class.getDeclaredFields();
        String line;
        while (!"HARVEST".equals(line = input.readLine())) {
            switch (line) {
                case "protected":
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isProtected(f.getModifiers()))
                            .forEach(f -> {
                                String modifiers = Modifier.toString(f.getModifiers());
                                String type = f.getType().getSimpleName();
                                String name = f.getName();

                                System.out.println(String.format("%s %s %s", modifiers, type, name));
                            });
                    break;
                case "private":
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isPrivate(f.getModifiers()))
                            .forEach(f -> {
                                String modifiers = Modifier.toString(f.getModifiers());
                                String type = f.getType().getSimpleName();
                                String name = f.getName();

                                System.out.println(String.format("%s %s %s", modifiers, type, name));
                            });
                    break;
                case "public":
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isPublic(f.getModifiers()))
                            .forEach(f -> {
                                String modifiers = Modifier.toString(f.getModifiers());
                                String type = f.getType().getSimpleName();
                                String name = f.getName();

                                System.out.println(String.format("%s %s %s", modifiers, type, name));
                            });
                    break;
                case "all":
                    Arrays.stream(fields)
                            .forEach(f -> {
                                String modifiers = Modifier.toString(f.getModifiers());
                                String type = f.getType().getSimpleName();
                                String name = f.getName();

                                System.out.println(String.format("%s %s %s", modifiers, type, name));
                            });
                    break;
            }
        }
    }
}
