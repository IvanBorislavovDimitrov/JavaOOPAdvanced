import java.util.Arrays;

public class ListyIterator {

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
            System.out.println("Invalid Operation!");
            return;
        }
        System.out.println(this.elements[index]);
    }
}
