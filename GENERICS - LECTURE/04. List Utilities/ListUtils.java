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
}
