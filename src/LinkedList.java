public class LinkedList {
    Node head;

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertNode(int data) {
        Node node = new Node(data);
        Node head = this.head;
        if (head == null) {
            this.head = node;
        } else {
            while (head.next != null) {
                head = head.next;
            }
            head.next = node;
        }
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "-> ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);
        list.insertNode(4);
        list.insertNode(5);
        list.printList(list.head);
    }
}
