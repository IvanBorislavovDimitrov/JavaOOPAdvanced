import java.util.ArrayList;
import java.util.List;

public class GenericBox<T extends Comparable<T>> {

    private List<T> values;

    public GenericBox() {
        this.values = new ArrayList<>();
    }

    public int countOfElementsBiggerThan(T element) {
        int count = 0;
        for (T e : this.values) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public List<T> getValues() {
        return this.values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
}
