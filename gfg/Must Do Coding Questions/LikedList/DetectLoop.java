package LikedList;

public class DetectLoop {
    public static boolean detectLoop(Node head){
        Node first = head, second = head;

        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }
}
