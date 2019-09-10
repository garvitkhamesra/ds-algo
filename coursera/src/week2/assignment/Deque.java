package week2.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable {
    private int first, last = -1;
    private Item deque[];

    @SuppressWarnings("compiler warning")
    public Deque() {
        this.deque = (Item[]) new Object[2];
        first = deque.length;
    }

    public boolean isEmpty() {
        return last == -1 && first == deque.length;
    }

    public int size() {
        if (last == -1 && first == deque.length) return 0;
        else {
            if (last > -1)
                return last + (deque.length - first) + 1;
            return (deque.length - first);
        }
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (size() == deque.length) resize(2 * deque.length);
        deque[--first] = item;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (size() == deque.length) resize(2 * deque.length);
        deque[++last] = item;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        if (first == deque.length) {
            Item data = deque[last];
            deque[last--] = null;
            if (size() == (deque.length / 4)) resize(deque.length / 2);
            return data;
        }
        Item data = deque[first];
        deque[first++] = null;
        if (size() == (deque.length / 4)) resize(deque.length / 2);
        return data;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (last == -1) {
            Item data = deque[first];
            deque[first++] = null;
            if (size() == (deque.length / 4)) resize(deque.length / 2);
            return data;
        }
        Item data = deque[last];
        deque[last--] = null;
        if (size() == (deque.length / 4)) resize(deque.length / 2);
        return data;
    }

    public Iterator<Item> iterator() {
        return new CustomIterator();
    }

    @SuppressWarnings("compiler warning")
    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];
        int tempLength = 0;
        for (int i = first; i < deque.length; i++) {
            temp[tempLength] = deque[i];
            tempLength++;
        }
        for (int i = 0; i <= last; i++) {
            temp[tempLength] = deque[i];
            tempLength++;
        }
        first = temp.length; last = tempLength-1;
        deque = temp;
    }

    private class CustomIterator implements Iterator<Item> {
        int i, j;
        CustomIterator() {
            i = first;
            j = 0;
        }

        public boolean hasNext() {
            return (i < deque.length || j <= last);
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            if (i < deque.length) {
                Item item = deque[i];
                i++;
                return item;
            } else if (j <= last){
                Item item = deque[j];
                j++;
                return item;
            }
            return null;
        }
        public void remove() {
        }
    }


    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.removeLast();
        deque.addLast(5);
        deque.addLast(6);
        deque.removeFirst();

        Iterator iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}