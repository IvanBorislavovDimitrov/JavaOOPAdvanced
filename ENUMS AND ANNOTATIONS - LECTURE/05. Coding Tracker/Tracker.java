import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Tracker {

    @Author(name = "Pesho")
    public static void printMethodsByAuthor(Class<?> klass) {
        Map<String, List<String>> methodsByAuthor = new LinkedHashMap<>();
        Method[] methods = klass.getMethods();
        for (Method method : methods) {
            for (Annotation annotation : method.getAnnotations()) {
                if (annotation instanceof Author) {
                    methodsByAuthor.putIfAbsent(((Author) annotation).name(), new ArrayList<>());
                    methodsByAuthor.get(((Author) annotation).name()).add(method.getName() + "()");
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        methodsByAuthor.forEach((k, v) -> {
            sb.append(k).append(": ").append(v.stream().sorted(String::compareTo)
                    .collect(Collectors.joining(", ")))
                    .append(System.lineSeparator());
        });

        System.out.println(sb.toString().trim());
    }

    @Author(name = "Pesho")
    public void imaITuka() {
    }
}
