package week2.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The type Deque.
 *
 * @param <Item> the type parameter
 */
public class Deque<Item> implements Iterable<Item> {
    private static final int SIZE_BY_FOUR = 4;
    private int first;
    private int last = -1;
    private Item[] deque = null;

    /**
     * Instantiates a new Deque.
     */
    public Deque() {
        this.deque = instantiate(2);
        first = deque.length;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return last == -1 && first == deque.length;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        if (last == -1 && first == deque.length) {
            return 0;
        } else {
            if (last > -1) {
                return last + (deque.length - first) + 1;
            }
            return (deque.length - first);
        }
    }

    /**
     * Add first.
     *
     * @param item the item
     */
    public void addFirst(final Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size() == deque.length) {
            resize(2 * deque.length);
        }
        deque[--first] = item;
    }

    /**
     * Add last.
     *
     * @param item the item
     */
    public void addLast(final Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size() == deque.length) {
            resize(2 * deque.length);
        }
        deque[++last] = item;
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
        if (first == deque.length) {
            Item data = deque[last];
            deque[last--] = null;
            if (size() == (deque.length / SIZE_BY_FOUR)) {
                resize(deque.length / 2);
            }
            return data;
        }
        Item data = deque[first];
        deque[first++] = null;
        if (size() == (deque.length / SIZE_BY_FOUR)) {
            resize(deque.length / 2);
        }
        return data;
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
        if (last == -1) {
            Item data = deque[first];
            deque[first++] = null;
            if (size() == (deque.length / SIZE_BY_FOUR)) {
                resize(deque.length / 2);
            }
            return data;
        }
        Item data = deque[last];
        deque[last--] = null;
        if (size() == (deque.length / SIZE_BY_FOUR)) {
            resize(deque.length / 2);
        }
        return data;
    }

    public Iterator<Item> iterator() {
        return new CustomIterator();
    }

    private void resize(final int length) {
        Item[] temp = instantiate(length);
        int tempLength = 0;
        for (int i = first; i < deque.length; i++) {
            temp[tempLength] = deque[i];
            tempLength++;
        }
        for (int i = 0; i <= last; i++) {
            temp[tempLength] = deque[i];
            tempLength++;
        }
        first = temp.length;
        last = tempLength - 1;
        deque = temp;
    }

    private class CustomIterator implements Iterator<Item> {
        private int i;
        private int j;

        /**
         * Instantiates a new Custom iterator.
         */
        CustomIterator() {
            i = first;
            j = 0;
        }

        public boolean hasNext() {
            return (i < deque.length || j <= last);
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (i < deque.length) {
                Item item = deque[i];
                i++;
                return item;
            } else if (j <= last) {
                Item item = deque[j];
                j++;
                return item;
            } else {
                throw new NoSuchElementException();
            }
        }
        public void remove() {
        }
    }


    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
	// For Unit Testing
    }

    private Item[] instantiate(int size) {
 	return (Item[]) new Object[size];
    }
}

