package easy.linkedlist;

/**
 * User: garvit
 * Date: 21/12/19 8:18 AM
 */

/*
Linked List Cycle
https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/
*/

public class LinkedCycleList {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}


/*
Find Loop Question
2 pointers
when equal loop is there when 1 points to null no loop is there
*/
