package linkedlist;

/**
 * User: garvit
 * Date: 21/12/19 9:37 AM
 */

/*
Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/
*/

public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        int t = len;
        len = len/2;
        ListNode prev = null;
        temp = head;
        ListNode sec = head;
        while (len > 0) {
            sec = sec.next;
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            len--;
        }
        sec = t%2 == 0? sec : sec.next;
        while (prev!=null && sec!=null) {
            if (prev.val != sec.val) return false;
            prev = prev.next;
            sec = sec.next;
        }
        return true;
    }
}
