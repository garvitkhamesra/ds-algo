package chapter2;

import linkedlist.ListNode;

import static chapter2.LinkedList.printList;

public class Partition {
    /*
        Question Explanation
            The question is to have all the smaller number then the given number before the number given and larger and
            equal after the number.
        Solution approaches
            1. With 4 variables
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(N)
    */

    public static ListNode partition(ListNode node, int partition) {
        ListNode lesserStart = null;
        ListNode lesserEnd = null;
        ListNode greaterStart = null;
        ListNode greaterEnd = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = null;

            if (node.val < partition) {
                if (lesserStart == null) {
                    lesserStart = node;
                    lesserEnd = lesserStart;
                } else {
                    lesserEnd.next = node;
                    lesserEnd = lesserEnd.next;
                }
            } else {
                if (greaterStart == null) {
                    greaterStart = node;
                    greaterEnd = greaterStart;
                } else {
                    greaterEnd.next = node;
                    greaterEnd = greaterEnd.next;
                }
            }
            node = next;
        }
        if (lesserStart ==  null) return greaterStart;
        lesserEnd.next = greaterStart;
        return lesserStart;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list = list.insert(list, 3);
        list = list.insert(list, 7);
        list = list.insert(list, 5);
        list = list.insert(list, 8);
        list = list.insert(list, 4);
        list = list.insert(list, 5);
        list = list.insert(list, 6);
        list = list.insert(list, 7);
        list = list.insert(list, 1);

        printList(list.head);
        System.out.println();
        ListNode head = Partition.partition(list.head, 5);
        printList(head);
    }
}
