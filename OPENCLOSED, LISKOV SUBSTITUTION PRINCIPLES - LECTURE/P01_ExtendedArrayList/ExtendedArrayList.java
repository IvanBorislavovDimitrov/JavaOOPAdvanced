package app.P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T> {

    private static final String LIST_IS_EMPTY = "List is empty";

    public T min() {
        if (super.size() == 0) {
            throw new IllegalArgumentException(LIST_IS_EMPTY);
        }

        T element = super.get(0);
        Iterator<T> iterator = super.iterator();
        while (iterator.hasNext()) {
            T currentElement = iterator.next();
            if (element.compareTo(currentElement) > 0) {
                element = currentElement;
            }
        }

        return element;
    }

    public T max() {
        if (super.size() == 0) {
            throw new IllegalArgumentException(LIST_IS_EMPTY);
        }

        T element = super.get(0);
        Iterator<T> iterator = super.iterator();
        while (iterator.hasNext()) {
            T currentElement = iterator.next();
            if (element.compareTo(currentElement) < 0) {
                element = currentElement;
            }
        }

        return element;
    }
}
