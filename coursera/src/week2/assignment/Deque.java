package week2.assignment;

import java.util.Iterator;



public class Deque<Item> {
    private int first, last = -1;
    private Item deque[];

    public Deque() {
        this.deque = (Item[]) new Object[2];
        first = deque.length;
    }

    public boolean isEmpty() {
        return last == -1 && first == deque.length;
    }

    public int size() {
        if (last == -1 && first == deque.length) return 0;
        else return (last - 0) + (deque.length - first) + 1;
    }

    public void addFirst(Item item) {
        if (size() == deque.length) resize(2 * deque.length);
        deque[++last] = item;
    }

    public void addLast(Item item) {
        if (size() == deque.length) resize(2 * deque.length);
        deque[--first] = item;
    }

    public Item removeFirst() {
        Item data = deque[last];
        deque[last--] = null;
        if (size() == (deque.length / 4)) resize(deque.length / 2);
        return data;
    }

    public Item removeLast() {
        Item data = deque[first];
        deque[first++] = null;
        if (size() == (deque.length / 4)) resize(deque.length / 2);
        return data;
    }

    public Iterator<Item> iterator() {
        return new CustomIterator();
    }

    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.removeFirst();
        deque.addLast(5);
        deque.addLast(6);
        deque.removeLast();
    }

    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];
        for (int i = 0; i <= last; i++) {
            temp[i] = deque[i];
        }
        int tempLength = length - 1;
        for (int i = deque.length - 1; i >= first; i--) {
            temp[tempLength] = deque[i];
            tempLength--;
        }
        first = tempLength;
        deque = temp;
    }

    private class CustomIterator implements Iterator<Item> {
        int i, j;
        CustomIterator() {
            i = first;
            j = 0;
        }

        public boolean hasNext() {
            return (i < deque.length && j <= last);
        }

        public Item next() {
            if (i < deque.length) {
                return deque[i--];
            } else {
                return deque[j++];
            }
        }
        public void remove() {
        }
    }
}
