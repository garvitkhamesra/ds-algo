package LikedList;

public class MiddleElement {
    int getMiddle(Node head) {
        Node first = head, second = head;
        while (first != null && first.next != null) {
            second = second.next;
            first = first.next.next;
        }
        return second.data;
    }
}
