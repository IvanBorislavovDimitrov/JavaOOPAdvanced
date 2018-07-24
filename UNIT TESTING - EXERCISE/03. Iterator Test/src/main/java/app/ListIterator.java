package app;

import javax.naming.OperationNotSupportedException;

public interface ListIterator<T> {

    T print() throws OperationNotSupportedException;

    boolean move();

    boolean hasNext();
}
