import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> reflectionClass = Reflection.class;

        Field[] fields = Arrays.stream(reflectionClass.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .toArray(Field[]::new);

        Method[] wrongGetters = Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get"))
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Method[] wrongSetters = Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("set"))
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        for (Field field : fields) {
            System.out.println(String.format("%s must be private!", field.getName()));
        }
        for (Method wrongGetter : wrongGetters) {
            System.out.println(String.format("%s have to be public!", wrongGetter.getName()));
        }
        for (Method wrongSetter : wrongSetters) {
            System.out.println(String.format("%s have to be private!", wrongSetter.getName()));
        }
    }
}
