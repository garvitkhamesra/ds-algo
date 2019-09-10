package week2.assignment;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int index;
    private Item[] queue;
    private Random random;

    @SuppressWarnings("compiler warning")
    public RandomizedQueue() {
        index = 0;
        queue = (Item[]) new Object[1];
        random = new Random();
    }
    public boolean isEmpty() {
        return index == 0;
    }
    public int size() {
        return index;
    }
    public void enqueue(Item item) {
        if (size() == queue.length) resize(2*queue.length);
        queue[index++] = item;
    }
    public Item dequeue() {
        if (size() == queue.length / 4) resize(queue.length/2);
        int i = random.nextInt(size());
        Item data = queue[i];
        swap(index-1, i);
        queue[index] = null;
        index--;
        return data;
    }
    public Item sample() {
        int i = random.nextInt(size());
        Item data = queue[i];
        return data;
    }
    public Iterator<Item> iterator() {
        return new CustomIterator();
    }
    public static void main(String[] args) {
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        randomizedQueue.dequeue();
        Iterator iterator = randomizedQueue.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @SuppressWarnings("compiler warning")
    private void resize(int size) {
        Item[] items = (Item[]) new Object[size];
        for (int i = 0; i < index; i++) {
            items[i] = queue[i];
        }
        queue = items;
    }
    private void swap(int x, int y) {
        Item temp = queue[x];
        queue[x] = queue[y];
        queue[y] = temp;
    }
    private class CustomIterator implements Iterator<Item> {
        private int i;
        public CustomIterator() {
            i = index-1;
        }
        public boolean hasNext() {
            return i >= 0;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            HashSet<Integer> generatedValue = new HashSet<>();
            int iter = random.nextInt(size());
            while (generatedValue.contains(iter)) {
                iter = random.nextInt(size());
            }
            generatedValue.add(iter);
            i--;
            return queue[iter];
        }
    }
}