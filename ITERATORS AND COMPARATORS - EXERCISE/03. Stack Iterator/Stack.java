import java.util.Iterator;

public class Stack implements Iterable<Integer> {

    private static final int MAX_CAPACITY = 16;

    private int index;
    private int[] elements;

    public Stack() {
        this.index = 0;
        this.elements = new int[MAX_CAPACITY];
    }

    public void push(int element) {
        this.elements[this.index++] = element;
    }

    public int pop() {
        if (this.index == 0) {
            throw new IllegalArgumentException("No elements");
        }
        return this.elements[this.index--];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<Integer> {

        private int i;

        private StackIterator() {
            this.i = index - 1;
        }

        @Override
        public boolean hasNext() {
            return this.i >= 0;
        }

        @Override
        public Integer next() {
            return elements[this.i--];
        }
    }

}
