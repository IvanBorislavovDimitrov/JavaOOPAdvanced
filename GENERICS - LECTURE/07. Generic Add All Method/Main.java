import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, null, 3);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.2, 1.23, 2.3241);

        List<Number> destination = new ArrayList<>();
        ListUtils.addAll(destination, integers);
        ListUtils.addAll(destination, doubles);

        System.out.println(destination);
    }
}
