package prj.clark.cs.dsa.struct.queue;

import prj.clark.cs.dsa.struct.deque.Deque;
import prj.clark.cs.dsa.struct.deque.DoublyLinkedListDeque;
import prj.clark.cs.dsa.struct.queue.Queue;

import java.util.Iterator;

/**
 * This is a hackneyed filler implementation that cheats by using a DoubleEndedQueue, and limiting it to one end of
 * functionality.
 * @param <E>
 */
public class WrapperQueue<E> implements Queue<E> {
    private Deque<E> cheat;

    public WrapperQueue() {
        cheat = new DoublyLinkedListDeque<>();
    }

    @Override
    public int size() {
        return cheat.size();
    }

    @Override
    public boolean isEmpty() {
        return cheat.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        cheat.pushLeft(e);
    }

    @Override
    public E dequeue() {
        return cheat.popRight();
    }

    @Override
    public E peek() {
        E peeked = cheat.popRight();
        cheat.pushRight(peeked);
        return peeked;
    }

    @Override
    public Iterator<E> iterator() {
        return cheat.iterator();
    }
}
