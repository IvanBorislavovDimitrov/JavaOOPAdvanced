import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> elements) {
        if (elements.isEmpty()) {
            throw new IllegalArgumentException("Collection is empty!");
        }
        T minElement = elements.get(0);
        for (T element : elements) {
            if (element.compareTo(minElement) < 0) {
                minElement = element;
            }
        }

        return minElement;
    }

    public static <T extends Comparable<T>> T getMax(List<T> elements) {
        if (elements.isEmpty()) {
            throw new IllegalArgumentException("Collection is empty!");
        }
        T maxElement = elements.get(0);
        for (T element : elements) {
            if (element.compareTo(maxElement) > 0) {
                maxElement = element;
            }
        }

        return maxElement;
    }

    public static List<Integer> getNullIndexes(List<?> elements) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == null) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    public static <T> void flatten(List<? super T> destination, List<List<? extends T>> source) {
        for (List<? extends T> ts : source) {
            destination.addAll(ts);
        }
    }

    public static <T> void addAll(List<? super T> destination, List<? extends T> source) {
        destination.addAll(source);
    }
}
