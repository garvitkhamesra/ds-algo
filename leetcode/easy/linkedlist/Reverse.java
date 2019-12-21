package easy.linkedlist;

/**
 * User: garvit
 * Date: 21/12/19 8:04 AM
 */

/*
Reverse Linked List
https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
*/

public class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}

/*
Recursive
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}*/
