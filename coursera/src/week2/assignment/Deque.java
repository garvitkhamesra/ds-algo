package week2.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The type Deque.
 *
 * @param <Item> the type parameter
 */
public class Deque<Item> implements Iterable<Item> {
    /**
     * The Head.
     */
    private Node<Item> head;
    /**
     * The Tail.
     */
    private Node<Item> tail;
    /**
     * The Deque size.
     */
    private int dequeSize;

    private class Node<Item> {
        /**
         * The Data.
         */
        Item data;
        /**
         * The Next.
         */
        Node<Item> next;
        /**
         * The Prev.
         */
        Node<Item> prev;

        /**
         * Instantiates a new Node.
         *
         * @param data the data
         */
        Node(Item data) {
            this.data = data;
        }
    }

    /**
     * Instantiates a new Deque.
     */
    public Deque() {
        dequeSize = 0;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return dequeSize == 0;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return dequeSize;
    }

    /**
     * Add first.
     *
     * @param item the item
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> newNode = new Node<Item>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        dequeSize++;
    }

    /**
     * Add last.
     *
     * @param item the item
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> newNode = new Node<Item>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        dequeSize++;
    }

    /**
     * Remove first item.
     *
     * @return the item
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item headData = head.data;
        if (dequeSize == 1) {
            head = null;
            tail = null;
        } else {
            Node<Item> headNext = head.next;
            headNext.prev = null;
            head = headNext;
        }
        dequeSize--;
        return headData;
    }

    /**
     * Remove last item.
     *
     * @return the item
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item tailData = tail.data;
        if (dequeSize == 1) {
            head = null;
            tail = null;
        } else {
            Node<Item> tailPrev = tail.prev;
            tailPrev.next = null;
            tail = tailPrev;
        }
        dequeSize--;
        return tailData;
    }

    /**
     * Iterator iterator.
     *
     * @return the iterator
     */
    public Iterator<Item> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<Item> {
        private Node<Item> temp;

        /**
         * Instantiates a new Custom iterator.
         */
        CustomIterator() {
            temp = head;
        }

        public boolean hasNext() {
            return temp != null;
        }
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item tempData = temp.data;
            temp = temp.next;
            return tempData;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // unit testing (required)
    }
}
