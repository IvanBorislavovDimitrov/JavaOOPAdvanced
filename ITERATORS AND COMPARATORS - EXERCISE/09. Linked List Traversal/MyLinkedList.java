import java.util.Iterator;
import java.util.List;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(T element) {
        if (head == null) {
            head = new Node(element);
            tail = head;
        } else {
            Node currentElement = tail;
            tail = new Node(element);
            tail.prev = currentElement;
            currentElement.next = tail;
        }

        size++;
    }

    @Override
    public void remove(T element) {
        Node start = head;
        while (start != null) {
            if (start.element.equals(element)) {
                if (start == head) {
                    head = head.next;
                    head.prev = null;
                    size--;
                    return;
                } else if (start == tail) {
                    tail = tail.prev;
                    tail.next = null;
                    size--;
                    return;
                } else {
                    start.prev.next = start.next;
                    start.next.prev = start.prev;
                    size--;
                    return;
                }
            }
            start = start.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private final class MyLinkedListIterator implements Iterator<T> {

        private Node start;

        public MyLinkedListIterator() {
            start = head;
        }

        @Override
        public boolean hasNext() {
            return start != null;
        }

        @Override
        public T next() {
            Node element = start;
            start = start.next;

            return element.element;
        }
    }

    @Override
    public int getSize() {
        return size;
    }
}
