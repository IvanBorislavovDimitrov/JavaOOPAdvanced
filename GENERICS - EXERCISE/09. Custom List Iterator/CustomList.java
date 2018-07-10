import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private static final int INITIAL_CAPACITY = 4;

    private Object[] elements;
    private int size;

    public CustomList() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public Object[] getElements() {

        return this.elements;
    }

    public T getMin() {
        if (this.elements.length == 0) {
            throw new IllegalArgumentException("List is empty!");
        }

        T minElement = (T) this.elements[0];
        for (int i = 1; i < this.size; i++) {
            if (minElement.compareTo((T) this.elements[i]) > 0) {
                minElement = (T) this.elements[i];
            }
        }

        return minElement;
    }

    public T getMax() {
        if (this.elements.length == 0) {
            throw new IllegalArgumentException("List is empty!");
        }

        T maxElement = (T) this.elements[0];
        for (int i = 1; i < this.size; i++) {
            if (maxElement.compareTo((T) this.elements[i]) < 0) {
                maxElement = (T) this.elements[i];
            }
        }

        return maxElement;
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (((T) this.elements[i]).compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public void swap(int i1, int i2) {
        if (i1 < 0 || i1 >= this.size || i2 < 0 || i2 >= this.size) {
            throw new IllegalArgumentException();
        }
        Object temp = this.elements[i1];
        this.elements[i1] = this.elements[i2];
        this.elements[i2] = temp;
    }

    public boolean contains(T element) {
        if (this.elements.length == 0) {
            throw new IllegalArgumentException("List is empty");
        }

        for (int i = 0; i <= this.size; i++) {
            if (element.equals((this.elements[i]))) {
                return true;
            }
        }

        return false;
    }

    public void add(T element) {
        if (this.size == this.elements.length) {
            this.grow();
        }
        this.elements[this.size] = element;
        this.size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Not a valid position!");
        }
        Object element = this.elements[index];
        shiftElementToEnd(index);
        this.size--;

        return (T) element;
    }

    private void shiftElementToEnd(int index) {
        this.elements[index] = null;
        for (int i = index; i < this.elements.length - 1; i++) {
            Object temp = this.elements[i];
            this.elements[i] = this.elements[i + 1];
            this.elements[i + 1] = temp;
        }
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        Object[] currentElements = this.elements;
        this.elements = new Object[this.elements.length * 2];
        System.arraycopy(currentElements, 0, this.elements, 0, currentElements.length);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int start = 0;

            @Override
            public boolean hasNext() {
                return start < size;
            }

            @Override
            public T next() {
                return (T) elements[start++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (int i = 0; i < this.size; i++) {
            action.accept((T) this.elements[i]);
        }
    }

}
