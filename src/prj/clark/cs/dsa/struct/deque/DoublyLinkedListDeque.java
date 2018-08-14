package prj.clark.cs.dsa.struct.deque;

public class DoublyLinkedListDeque<T> implements Deque<T> {
    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(T item) {
            this.item = item;

            next = null;
            prev = null;
        }
    }

    private Node<T> left;
    private Node<T> right;
    private int size;

    public DoublyLinkedListDeque() {
        left = null;
        right = null;

        size = 0;
    }

    @Override
    public T popBack() {
        if (size <= 0 || left == null) {
            return null;
        }

        T popped = left.item;
        left = left.next;

        size--;

        return popped;
    }

    @Override
    public T popFront() {
        if (size <= 0 || right == null) {
            return null;
        }

        T popped = right.item;
        right = right.prev;

        size--;

        return popped;
    }

    @Override
    public void pushBack(T elem) {
        if (left == null) {
            left = new Node<>(elem);
            left.next = right;
        } else {
            Node<T> pushed = new Node<>(elem);
            pushed.prev = null;
            pushed.next = left;
            left = pushed;
        }

        size++;
    }

    @Override
    public void pushFront(T elem) {
        if (right == null) {
            right = new Node<>(elem);
            right.prev = left;
        } else {
            Node<T> pushed = new Node<>(elem);
            pushed.next = null;
            pushed.prev = right;
            right = pushed;
        }

        size++;
    }

    @Override
    public int size() {
        return size;
    }
}
