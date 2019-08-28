import java.util.Iterator;

public class LinkedQueue<T> implements Iterable<T> {
    private Node head, last;

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>();
    }

    private class ListIterator<T> implements Iterator<T>{

        private Node current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = (T) current.data;
            current = current.next;
            return data;
        }
    }

    private class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    public T dequeue() {
        T data = head.data;
        head = head.next;
        return data;
    }

    public void enqueue(T data) {
        if (isEmpty()) {
            head = new Node(data);
            last = head;
            return;
        }
        Node node = new Node(data);
        last.next = node;
        last = node;
    }

    public void printStack(Node head) {
        while (head != null) {
            System.out.print(head.data + "-> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        linkedQueue.printStack(linkedQueue.head);
        linkedQueue.dequeue();
        linkedQueue.dequeue();
        linkedQueue.printStack(linkedQueue.head);
        linkedQueue.enqueue(3);
        linkedQueue.enqueue(3);
        linkedQueue.printStack(linkedQueue.head);
    }
}
