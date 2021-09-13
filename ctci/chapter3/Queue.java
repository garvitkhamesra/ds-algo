package chapter3;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Queue<T> {
    private class QueueNode<T> {
        T data;
        QueueNode<T> next;

        QueueNode(T data) {
            this.data = data;
        }
    }

    QueueNode<T> first, last;

    public boolean isEmpty() {
        return first == null;
    }

    public void add(T val) {
        QueueNode node = new QueueNode(val);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = last;
        }
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if (first == null) last = null;
        return data;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue();
        queue.add(1);
        System.out.println(queue.peek());
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.peek());

    }
}
