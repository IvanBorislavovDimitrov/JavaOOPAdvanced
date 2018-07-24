package app;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIteratorImpl<T> implements ListIterator<T> {

    private List<T> elements;
    private int index;

    public ListIteratorImpl(T... elements) {
        this.elements = new ArrayList<>(Arrays.asList(elements));
        this.index = 0;
    }

    @Override
    public T print() throws OperationNotSupportedException {
        if (this.index < this.elements.size()) {
            return this.elements.get(this.index);
        }

        throw new OperationNotSupportedException("Invalid Operation!");
    }

    @Override
    public boolean move() {
        if (this.hasNext()) {
            this.index++;
            return true;
        }

        return false;
    }

    @Override
    public boolean hasNext() {
        return this.index + 1 < this.elements.size();
    }
}
