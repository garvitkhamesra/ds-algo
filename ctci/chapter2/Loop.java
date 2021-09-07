package chapter2;

import linkedlist.ListNode;

public class Loop {
    public ListNode getLoopNode(ListNode head) {
        ListNode first = head, second = head;
        while (first != null && first.next != null) {
            first = first.next.next;
            second = second.next;
            if (second == first) break;
        }

        if (first == null || first.next == null) {
            return null;
        }

        second = head;
        while (second != first) {
            second = second.next;
            first = first.next;
        }
        return first;
    }
}
