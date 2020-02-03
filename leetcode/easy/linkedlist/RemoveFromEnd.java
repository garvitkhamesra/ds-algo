package linkedlist;

/**
 * User: garvit
 * Date: 20/12/19 9:05 AM
 */

/*
Remove from end
https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/
*/

public class RemoveFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        while (n >= 0) {
            first = first.next;
            n--;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
