package dp;

import java.util.HashMap;

public class LRUInt {

    /*
        Access time for any item should be O(1).
        Time required to get the least recently used element should be O(1).
        Time required to put any item should be O(1).
        The space required should be O(n).
    */

    class Node {
        private int data;
        private int value;
        private Node prev;
        private Node next;

        public Node(int data, int value) {
            this.data = data;
            this.value = value;
        }

        public Node() {

        }
    }

    private int currentCapacity;
    private int maxCapacity;
    private HashMap<Integer, Node> map;

    private Node head;
    private Node tail;

    LRUInt(int capacity) {
        maxCapacity = capacity;
        map = new HashMap<>(capacity);

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // if found we need to get the data and change its location to head.
        int data = map.get(key).value;

        removeData(map.get(key));
        Node node = addAtFirst(key, data);
        map.put(key, node);
        return data;
    }

    public void put(int key, int data) {
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

    private Node addAtFirst(int key, int data) {
        Node node = new Node(key, data);

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;

        return node;
    }

    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(2,1);
        lru.put(1,1);
        lru.put(2,3);
        lru.put(4,1);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }
}
