package chapter2;

import linkedlist.ListNode;

import static chapter2.LinkedList.printList;

public class ReturnKthToLast {
    /*
        Question Explanation
            The question is to return the kth element from last
        Solution approaches
            1. In single pass
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(1)
            2. In 2 pass
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(1)
    */

    public static ListNode kthFromLastSinglePass(ListNode head, int k) {
        ListNode first = head, second = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static ListNode kthFromLastWithLength(ListNode head, int k) {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        int i = len - k;
        ListNode temp = head;
        while (i > 0 & temp != null) {
            temp = temp.next;
            i--;
        }

        return temp;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list = list.insert(list, 1);
        list = list.insert(list, 2);
        list = list.insert(list, 5);
        list = list.insert(list, 4);
        list = list.insert(list, 5);
        list = list.insert(list, 6);
        list = list.insert(list, 7);
        list = list.insert(list, 5);

        System.out.println(kthFromLastSinglePass(list.head, 3).val);
        System.out.println(kthFromLastSinglePass(list.head, 8).val);
        System.out.println(kthFromLastSinglePass(list.head, 1).val);

        System.out.println(kthFromLastWithLength(list.head, 3).val);
        System.out.println(kthFromLastWithLength(list.head, 8).val);
        System.out.println(kthFromLastWithLength(list.head, 1).val);

        printList(list);
    }
}
