import java.util.Iterator;

public interface MyList<T extends Comparable<T>> extends Iterable<T> {

    void add(T element);

    void remove(T element);

    int getSize();
}
