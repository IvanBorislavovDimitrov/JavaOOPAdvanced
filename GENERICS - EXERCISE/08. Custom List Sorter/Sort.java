import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sort {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        customList.sort();
    }
}
