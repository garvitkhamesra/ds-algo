package challenge;

/**
 * User: garvit
 * Date: 16/02/21 2:40 PM
 */
public class HashMapImpl {

    Node[] nodes = new Node[1000];

    public void put(int key, int value) {
        int hash = hashCode(key);
        Node node = search(key, nodes[hash]);
        if (node == null) {

        }
        if (node.next == null) {
            node.next = new Node(key, value);
        } else {
            node.next.value = value;
        }
    }

    public int get(int key) {
        int hash = hashCode(key);
        if (nodes[hash] == null) {
            return -1;
        }
        Node result = search(key, nodes[hash]);
        if (result == null) return nodes[hash].value;
        if (result.next == null) return -1;
        return result.next.value;
    }

    public void remove(int key) {
        int hash = hashCode(key);
        if (nodes[hash] == null) {
            return;
        }
        Node node = search(key, nodes[hash]);
        if (node == null) return;
        if (node.next != null)
            node.next = node.next.next;
    }

    private int hashCode(int key) {
        return key % 10;
    }

    private Node search(int key, Node list) {
        Node node = list, prev = null;
        while (node != null && key != node.key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
