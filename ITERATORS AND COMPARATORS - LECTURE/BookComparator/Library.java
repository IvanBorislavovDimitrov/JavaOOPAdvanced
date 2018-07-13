import java.util.Iterator;

public class Library<T> implements Iterable<T> {

    private T[] elements;

    public Library(T... elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<T> iterator() {
        return new LibIterator();
    }

    private class LibIterator implements Iterator<T> {

        private int index;

        public LibIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < elements.length;
        }

        @Override
        public T next() {
            return elements[index++];
        }
    }
}
