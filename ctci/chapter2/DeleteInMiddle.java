package chapter2;

import linkedlist.ListNode;

import java.util.HashSet;

import static chapter2.LinkedList.printList;

public class DeleteInMiddle {
    /*
        Question Explanation
            The question is to delete the given node
        Solution approaches
            1. In single pass
                1.1 Time Complexity : O(1)
                1.2 Space Complexity : O(1)
    */

    public static void deleteGivenNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
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

        printList(list.head);
        DeleteInMiddle.deleteGivenNode(list.head.next.next.next);
        System.out.println();
        printList(list.head);
    }
}
