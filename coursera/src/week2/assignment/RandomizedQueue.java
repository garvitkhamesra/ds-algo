package week2.assignment;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The type Randomized queue.
 *
 * @param <Item> the type parameter
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int index;
    private Item[] queue;

    /**
     * Instantiates a new Randomized queue.
     */
    public RandomizedQueue() {
        index = 0;
        queue = instantiate(2);
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return index == 0;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return index;
    }

    /**
     * Enqueue.
     *
     * @param item the item
     */
    public void enqueue(final Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size() == queue.length) {
            resize(2 * queue.length);
        }
        queue[index++] = item;
    }

    /**
     * Dequeue item.
     *
     * @return the item
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size() == queue.length / 4) {
            resize(queue.length / 2);
        }
        int i = 0;
        if (size() - 1 != 0) {
            i = StdRandom.uniform(size());
        }
        Item data = queue[i];
        index--;
        swap(index, i);
        queue[index] = null;
        return data;
    }

    /**
     * Sample item.
     *
     * @return the item
     */
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int i = 0;
        if (size() - 1 != 0) {
            i = StdRandom.uniform(size());
        }
        Item data = queue[i];
        return data;
    }
    public Iterator<Item> iterator() {
        return new CustomIterator();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // For unit testing
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(4);
        rq.enqueue(1);
        rq.enqueue(0);
        rq.enqueue(0);
        rq.dequeue();
    }

    private void resize(int size) {
        Item[] items = instantiate(size);
        for (int i = 0; i < index; i++) {
            items[i] = queue[i];
        }
        queue = items;
    }
    private void swap(final int x, final int y) {
        Item temp = queue[x];
        queue[x] = queue[y];
        queue[y] = temp;
    }
    private class CustomIterator implements Iterator<Item> {
        private int i;
        private Item[] tempQueue;
        /**
         * Instantiates a new Custom iterator.
         */
        CustomIterator() {
            i = index - 1;
            tempQueue = queue;
        }
        public boolean hasNext() {
            return i >= 0;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int iter = 0;
            if (size() - 1 != 0) {
                iter = StdRandom.uniform(i+1);
            }
            Item temp = tempQueue[iter];
            tempQueue[iter] = tempQueue[i];
            tempQueue[i] = temp;

            i--;
            return temp;
        }
    }

    private Item[] instantiate(int size) {
        return (Item[]) new Object[size];
    }
}
