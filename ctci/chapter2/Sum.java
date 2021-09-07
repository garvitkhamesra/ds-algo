package chapter2;

import linkedlist.ListNode;

import java.util.Stack;

import static chapter2.LinkedList.*;

public class Sum {
    /*
        Question Explanation
            The question is to get the resultant sum using 2 linked lis. But ther followp is if we can do it if the
             lists are forward.
        Solution approaches
            1. If list are backward : maintain carry
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(N)
    */

   public static ListNode getSum(ListNode first, ListNode second) {
       if (first == null) return second;
       if (second == null) return first;
       ListNode dum = new ListNode(0);
       ListNode dummy = dum;
       int c = 0;
       while (first != null || second != null) {
           int x = 0, y = 0;
           if (first != null) {
               x = first.val;
               first = first.next;
           }
           if (second != null) {
               y = second.val;
               second = second.next;
           }
           int temp = 0;
           if (x+y+c >= 10) {
               temp = x+y+c - 10;
               c = 1;
           } else {
               temp = x+y+c;
               c = 0;
           }
           ListNode node = new ListNode(temp);
           dummy.next = node;
           dummy = dummy.next;
       }
       if (c == 1) {
           dummy.next = new ListNode(1);
           dummy = dummy.next;
       }
       return dum.next;
   }

    public static ListNode getSumForwardListRecursion(ListNode first, ListNode second) {
        if (first == null) return second;
        if (second == null) return first;

        int len1 = getLength(first);
        int len2 = getLength(second);

        if (len1 < len2) first = padZero(first, len2 - len1);
        else if (len2 < len1) second = padZero(second, len1 - len2);

        ListNode result = addLists(first, second);
        if (carryVal == 1) result = insertBefore(result, 1);
        return result;
    }

    static int carryVal = 0;
    private static ListNode addLists(ListNode first, ListNode second) {
        if (first == null && second == null) return null;
        ListNode result = addLists(first.next, second.next);

        int sum = carryVal + first.val + second.val;
        ListNode temp = new ListNode();
        if (sum >= 10) {
            temp.val = sum % 10;
            carryVal = 1;
        } else {
            temp.val = sum;
            carryVal = 0;
        }
        if (result == null) {
            result = temp;
        } else {
            result = insertBefore(result, temp.val);
        }
        return result;
    }

    private static ListNode padZero(ListNode node, int diff) {
        ListNode result = null;
        while (diff > 0) {
            result = insertBefore(node, 0);
            diff--;
        }
        return result;
    }

    private static int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static ListNode getSumForwardListIterative(ListNode first, ListNode second) {
        if (first == null) return second;
        if (second == null) return first;

        ListNode result = null;
        int len1 = getLength(first);
        int len2 = getLength(second);

        if (len1 < len2) first = padZero(first, len2 - len1);
        else if (len2 < len1) second = padZero(second, len1 - len2);

        Stack<Integer> firstS = new Stack<>();
        Stack<Integer> secondS = new Stack<>();

        while (first != null) {
            firstS.add(first.val);
            first = first.next;
        }
        while (second != null) {
            secondS.add(second.val);
            second = second.next;
        }

        int carry = 0;
        while (!firstS.empty() && !secondS.empty()) {
            int x = firstS.pop();
            int y = secondS.pop();
            int sum = carry + x + y;
            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result = insertBefore(result, sum);
        }
        if (carry == 1) {
            result = insertBefore(result, 1);
        }
        return result;
    }

    public static ListNode getSumRecursion(ListNode first, ListNode second, int carry) {
        if (first == null && second == null && carry == 0) return null;
        int sum = carry;
        if (first != null) sum += first.val;
        if (second != null) sum += second.val;

        ListNode result = new ListNode();
        result.val = sum % 10;

        if (first != null || second != null) {
            result.next = getSumRecursion(first == null ? null : first.next, second == null ? null : second.next,
                    sum > 10 ? 1 : 0);
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList first = new LinkedList();
        first = first.insert(first, 3);
        first = first.insert(first, 7);
        first = first.insert(first, 5);

        LinkedList second = new LinkedList();
        second = second.insert(second, 8);
        second = second.insert(second, 4);
        second = second.insert(second, 5);

        printList(first.head);
        printList(second.head);
        System.out.println();
//        ListNode listNode = getSum(first.head, second.head);
//        ListNode listNode = getSumRecursion(first.head, second.head, 0);
//        ListNode listNode = getSumForwardListRecursion(first.head, second.head);
        ListNode listNode = getSumForwardListIterative(first.head, second.head);
        printList(listNode);
    }
}

