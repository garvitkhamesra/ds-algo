package easy.linkedlist;

/**
 * User: garvit
 * Date: 21/12/19 8:17 AM
 */

/*
Merge Two Sorted Lists
https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/
*/

public class Merge2SortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode res = ans;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ans.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                ans.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            ans = ans.next;
        }
        ans.next = l1 == null ? l2:l1;
        return res.next;
    }
}
