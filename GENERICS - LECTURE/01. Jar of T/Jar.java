import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class Jar<T> {

    private Deque<T> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove() {
        if (this.elements.isEmpty()) {
            throw new IllegalArgumentException("List is empty!");
        }
        return this.elements.pop();
    }
}
