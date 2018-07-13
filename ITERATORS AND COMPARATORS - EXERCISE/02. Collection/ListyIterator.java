import java.util.Iterator;

public class ListyIterator implements Iterable<String> {

    private int index;
    private String[] elements;

    public ListyIterator(String... elements) {
        this.index = 0;
        this.elements = elements;
    }

    public boolean hasNext() {
        return index + 1 < this.elements.length;
    }

    public boolean move() {
        if (this.hasNext()) {
            this.index++;
            return true;
        }

        return false;
    }

    public void print() {
        if (this.elements.length <= index) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(this.elements[index]);
    }

    @Override
    public Iterator<String> iterator() {
        return new ListyBuildInIterator();
    }

    private final class ListyBuildInIterator implements Iterator<String> {

        private int count;

        public ListyBuildInIterator() {
            this.count = 0;
        }

        @Override
        public boolean hasNext() {
            return this.count < elements.length;
        }

        @Override
        public String next() {
            return elements[count++];
        }
    }
}
