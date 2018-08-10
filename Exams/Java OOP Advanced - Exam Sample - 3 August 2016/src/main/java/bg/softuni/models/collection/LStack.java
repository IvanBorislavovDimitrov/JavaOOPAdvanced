package bg.softuni.models.collection;

import bg.contracts.Fragment;
import bg.contracts.Stack;
import bg.softuni.models.models.cores.SystemCore;

import java.util.Iterator;
import java.util.LinkedList;

public class LStack<T extends Fragment> implements Stack<T> {

    private LinkedList<T> innerList;

    public LStack() {
        this.innerList = new LinkedList<>();
    }

    @Override
    public Integer size() {
        return this.innerList.size();
    }

    @Override
    public T push(T item) {
        this.innerList.addLast(item);
        return item;
    }

    @Override
    public T pop() {
        T removedItem = this.innerList.removeLast();

        return removedItem;
    }

    // FIXME
    @Override
    public T peek() {
        T peekedItem = this.innerList.getLast();

        return peekedItem;
    }

    @Override
    public Boolean isEmpty() {
        return this.innerList.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return innerList.iterator();
    }
}