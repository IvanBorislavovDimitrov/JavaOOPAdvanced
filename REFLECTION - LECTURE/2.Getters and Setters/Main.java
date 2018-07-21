import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> reflectionClass = Reflection.class;

        Method[] getters = Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(m -> m.getName()
                        .startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Method[] setters = Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(m -> m.getName()
                        .startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        for (Method getter : getters) {
            System.out.println(String.format("%s will return %s", getter.getName(), getter.getReturnType()));
        }
        for (Method setter : setters) {
            Parameter[] parameters = setter.getParameters();
            parameters[0].getType();
            System.out.println(String.format("%s and will set field of %s", setter.getName(), parameters[0].getType()));
        }
    }
}
