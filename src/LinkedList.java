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
        System.out.println();
    }

    public void deleteWithKey(int data) {
        Node node = this.head;
        Node prevNode = null;

        while (node != null) {
            if (node.data == data) {
                if (prevNode == null) {
                    this.head = node.next;
                    break;
                }
                prevNode.next = node.next;
                break;
            }
            prevNode = node;
            node = node.next;
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
        list.deleteWithKey(2);
        list.deleteWithKey(1);
        list.deleteWithKey(5);
        list.deleteWithKey(1);
        list.deleteWithKey(8);
        list.printList(list.head);
    }
}
