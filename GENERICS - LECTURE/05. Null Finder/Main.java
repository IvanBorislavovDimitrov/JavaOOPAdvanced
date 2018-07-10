import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, null, 3, null);

        List<Integer> nullableIndexes = ListUtils.getNullIndices(integers);
        System.out.println(nullableIndexes);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "Pesho", "Doncho", null, null, "Drugiq");
        nullableIndexes = ListUtils.getNullIndices(strings);

        System.out.println(nullableIndexes);
    }
}
