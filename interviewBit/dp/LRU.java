package dp;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class LRU<E> {

    /*
        Access time for any item should be O(1).
        Time required to get the least recently used element should be O(1).
        Time required to put any item should be O(1).
        The space required should be O(n).
    */

    class Node {
        private E data;
        private E value;
        private Node prev;
        private Node next;

        public Node(E data, E value) {
            this.data = data;
            this.value = value;
        }

        public Node() {

        }
    }

    private int currentCapacity;
    private final int maxCapacity;
    private HashMap<E, Node> map;

    private Node head;
    private Node tail;

    LRU(int capacity) {
        maxCapacity = capacity;
        map = new HashMap<>(capacity);

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public E get(E key) throws NoSuchElementException {
        if (!map.containsKey(key)) {
            throw new NoSuchElementException("No Key Found");
        }

        // if found we need to get the data and change its location to head.
        E data = map.get(key).value;

        removeData(map.get(key));
        Node node = addAtFirst(key, data);
        map.put(key, node);
        return data;
    }

    public void put(E key, E data) {
        if (map.containsKey(key)) {
            // if the item is already present remove it from there and add it at front
            removeData(map.get(key));
            Node node = addAtFirst(key, data);
            map.put(key, node);

        } else {
            if (currentCapacity >= maxCapacity) {
                // then we need to remove the tail element from list and the key from hashmap
                map.remove(tail.prev.data);
                removeData(tail.prev);
                currentCapacity--;
            }

            // add the new element at the top
            Node node = addAtFirst(key, data);
            map.put(key, node);
            currentCapacity++;
        }
    }

    private void removeData(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private Node addAtFirst(E key, E data) {
        Node node = new Node(key, data);

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;

        return node;
    }
}
