import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sort {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        Arrays.sort(customList.getElements(), (x1, x2) -> {
            if (x1 == null && x2 == null) {
                return 0;
            }
            if (x1 == null) {
                return 1;
            }
            if (x2 == null) {
                return -1;
            }
            return ((T) x1).compareTo(((T) x2));
        });
    }
}
