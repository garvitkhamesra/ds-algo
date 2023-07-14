package dp;

import java.util.Hashtable;


public class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }


    private Hashtable<Integer, Node>
            cache = new Hashtable<Integer, Node>();
    private int count;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new Node();
        head.prev = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        Node node = cache.get(key);
        if(node == null){
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }


    public void put(int key, int value) {
        Node node = cache.get(key);

        if(node == null){

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if(count > capacity){
                // pop the tail
                Node tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }else{
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(Node node) {

        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(Node node){
        Node pre = node.prev;
        Node post = node.next;

        pre.next = post;
        post.prev = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(Node node){
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private Node popTail(){
        Node res = tail.prev;
        this.removeNode(res);
        return res;
    }

}