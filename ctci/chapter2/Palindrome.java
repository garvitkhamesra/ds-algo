package chapter2;

import static chapter2.LinkedList.*;
import linkedlist.ListNode;

import java.util.Stack;

public class Palindrome {

    public static boolean isPalindromeIterativeApp(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            stack.add(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) slow = slow.next;
        // to skip the middle element in case of odd len list

        while (!stack.empty()) {
            if (slow.val != stack.pop()) return false;
            slow = slow.next;
        }
        return true;
    }

    public static boolean isPalindromeReverse(ListNode head) {
        boolean result = false;
        ListNode fast = head, slow = head, prev = head, mid = null, secondHalf = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        if (fast != null) {
            mid = slow;
            slow = slow.next;
        }

        secondHalf = slow;
        prev.next = null;

        secondHalf = reverse(secondHalf);
        result = compareBothHalves(head, secondHalf);
        secondHalf = reverse(secondHalf); // getting the list in correct order

        if (mid != null) {
            prev.next = mid;
            mid.next = secondHalf;
        } else {
            prev.next = secondHalf;
        }

        return result;
    }

    static ListNode leftIter = null;

    public static boolean isPalindromeRecursion(ListNode head) {
        leftIter = head;
        return isPalindromeRecursionHelper(head);
    }

    private static boolean isPalindromeRecursionHelper(ListNode head) {
        if (head == null) return true;
        boolean result = isPalindromeRecursionHelper(head.next);
        if (head.val != leftIter.val) result = false;
        leftIter = leftIter.next;
        return result;
    }

    public static ListNode reverse(ListNode node) {
        ListNode next, prev = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    private static boolean compareBothHalves(linkedlist.ListNode head, linkedlist.ListNode secondHalf) {
        while (head != null && secondHalf != null) {
            if (head.val != secondHalf.val) return false;
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list = list.insert(list, 3);
        list = list.insert(list, 7);
        list = list.insert(list, 5);
        list = list.insert(list, 8);
        list = list.insert(list, 5);
        list = list.insert(list, 7);
        list = list.insert(list, 3);

        printList(list.head);
        System.out.println();
        System.out.println(isPalindromeIterativeApp(list.head));
        System.out.println(isPalindromeReverse(list.head));
        System.out.println(isPalindromeRecursion(list.head));
    }
}
