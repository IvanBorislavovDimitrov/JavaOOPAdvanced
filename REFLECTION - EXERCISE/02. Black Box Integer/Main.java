package pr02PrivateClassFiddling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        Constructor<BlackBoxInt> blackBoxIntConstructor = BlackBoxInt.class.getDeclaredConstructor();
        blackBoxIntConstructor.setAccessible(true);
        BlackBoxInt blackBoxClass = blackBoxIntConstructor.newInstance();
        String line;
        while (!"END".equals(line = input.readLine())) {
            String[] tokens = line.split("_");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);
            executeCommand(command, number, blackBoxClass);
            Field innerValue = blackBoxClass.getClass().getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBoxClass));
        }
    }

    private static void executeCommand(String command, int number, BlackBoxInt blackBoxInt) throws InvocationTargetException, IllegalAccessException {
        Method[] declaredMethods = blackBoxInt.getClass().getDeclaredMethods();
        Method method = Arrays.stream(declaredMethods).filter(m -> m.getName().equals(command)).findAny().get();
        method.setAccessible(true);
        method.invoke(blackBoxInt, number);
    }
}
