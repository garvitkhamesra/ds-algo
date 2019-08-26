/*Commented code is when list is grown right side
  Un-Commented code is adding list from left side
  Ths helps us to reduce the complexity to constant time rather then looping
    */

public class LinkedStack {
    private Node head;
    private class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        /*Node node = new Node(data);
        Node head = this.head;
        if (isEmpty()) {
            this.head = node;
        } else {
            while (head.next != null) {
                head = head.next;
            }
            head.next = node;
        }*/

        Node node = new Node(data);
        Node prevHead = this.head;
        if (isEmpty()) { this.head = node; }
        node.next = prevHead;
        this.head = node;
    }

    public int pop() {
        /*int data = -1;
        Node prevNode = head;
        Node node = head;
        if (isEmpty()) {
            return data;
        }
        while (node.next != null) {
            prevNode = node;
            node = node.next;
        }
        data = node.data;
        prevNode.next = null;
        return data; */

        Node node = head.next;
        int data = head.data;
        head.next = null;
        head = node;
        return data;
    }

    public void printStack(Node head) {
        while (head != null) {
            System.out.print(head.data + "-> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);

        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());

        linkedStack.push(3);
        linkedStack.push(3);

        linkedStack.printStack(linkedStack.head);
    }
}