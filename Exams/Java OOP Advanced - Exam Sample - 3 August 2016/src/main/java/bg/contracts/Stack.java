package bg.contracts;

public interface Stack<T extends Fragment> extends Iterable<T> {
    Integer size();

    T push(T item);

    T pop();

    // FIXME
    T peek();

    Boolean isEmpty();
}
