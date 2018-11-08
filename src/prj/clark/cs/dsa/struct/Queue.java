package prj.clark.cs.dsa.struct;

public interface Queue<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E peek();
}
