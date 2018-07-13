import java.util.Iterator;

public class Lake implements Iterable<Integer> {

    private int[] elements;

    public Lake(int... integers) {
        this.elements = integers;
    }

    private class Frog implements Iterator<Integer> {

        private int count;
        private int oddIndex;
        private int evenIndex;

        private Frog() {
            this.count = 0;
            this.oddIndex = 1;
            this.evenIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return this.count < elements.length;
        }

        @Override
        public Integer next() {
            if (this.count < (elements.length / 2.0)) {
                int element = elements[this.evenIndex];
                this.evenIndex += 2;
                this.count++;

                return element;
            } else {
                int element = elements[this.oddIndex];
                this.oddIndex += 2;
                this.count++;

                return element;
            }

        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
}
