package app;

import javax.naming.OperationNotSupportedException;

public class Database<T> {

    private T[] elements;
    private int length;

    @SuppressWarnings("unchecked")
    public Database(int capacity) throws OperationNotSupportedException {
        if (capacity != 16) {
            throw new OperationNotSupportedException("Capacity must be 16!");
        }

        this.elements = (T[]) new Object[capacity];
    }

    public int getLength() {
        return this.length;
    }

    public void add(T number) throws OperationNotSupportedException {
        if (number == null) {
            throw new OperationNotSupportedException("Element cannot be null!");
        }
        if (this.length == this.elements.length) {
            throw new OperationNotSupportedException("Capacity reached!");
        }
        this.elements[this.length] = number;
        this.length++;
    }

    public T remove() throws OperationNotSupportedException {
        if (this.length == 0) {
            throw new OperationNotSupportedException("No elements!");
        }
        T element = this.elements[this.length - 1];
        this.elements[this.length - 1] = null;
        this.length--;

        return element;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] arr = (T[]) new Object[this.length];
        System.arraycopy(this.elements, 0, arr, 0, arr.length);

        return arr;
    }
}
