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

    private void deleteWithKey(int data) {
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

    private void deleteAtGivenPosition(int position) {
        Node node = this.head;
        Node prevNode = null;
        int i = 0;

        while (node != null) {
            if (position == 0) {
                this.head = node.next;
                break;
            } else if (position == i) {
                prevNode.next = node.next;
                break;
            }

            prevNode = node;
            node = node.next;
            i++;
        }
    }

    private int length(Node head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    private int lengthWithRecursion(Node head) {
        if (head == null) return 0;
        return 1 + lengthWithRecursion(head.next);
    }

    private void swapNodes(int x, int y) {
        Node node = this.head;
        Node prevNodeX = null;
        Node prevNodeY = null;
        Node X = null, Y = null;

        while (node.next != null) {
            if (node.next.data == x) {
                X = node.next;
                prevNodeX = node;
            } else if (node.next.data == y) {
                Y = node.next;
                prevNodeY = node;
            }
            node = node.next;
        }

        prevNodeX.next = Y;
        Node temp = Y.next;
        Y.next = X.next;

        prevNodeY.next = X;
        X.next = temp;

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);
        list.insertNode(4);
        list.insertNode(5);
        list.insertNode(9);
        list.insertNode(6);
        list.insertNode(5);
        list.insertNode(8);
        list.printList(list.head);
        list.deleteWithKey(2);
        list.deleteWithKey(1);
        list.printList(list.head);
        list.deleteAtGivenPosition(8);
        list.deleteAtGivenPosition(2);
        list.printList(list.head);
        int length = list.length(list.head);
        System.out.println(length);
        int lengthWithRecursion = list.lengthWithRecursion(list.head);
        System.out.println(lengthWithRecursion);
        list.swapNodes(8, 1);
        list.printList(list.head);
    }
}
