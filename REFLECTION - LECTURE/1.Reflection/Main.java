import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> ref = Reflection.class;
        System.out.println(Reflection.class);
        System.out.println(Reflection.class.getSuperclass());
        Class<?>[] interfaces = Reflection.class.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Reflection reflection = Reflection.class.getConstructor().newInstance();
        System.out.println(reflection);
    }
}
