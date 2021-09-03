package chapter2;

import linkedlist.ListNode;

import java.util.HashSet;

import static chapter2.LinkedList.printList;

public class RemoveDuplicate {
    /*
        Question Explanation
            The question is to remove duplicate, with and without extra buffer
        Solution approaches
            1. With buffer: use hashset and remove
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(N)
            2. Without Buffer
                1.1 Time Complexity : O(N^2)
                1.2 Space Complexity : O(1)
    */

    public static ListNode removeDuplicateWithBuffer(ListNode head) {
        HashSet<Integer> hashset = new HashSet<>();
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            if (hashset.contains(node.val)) {
                prev.next = node.next;
            } else {
                prev = node;
                hashset.add(node.val);
            }
            node = node.next;
        }
         return head;
    }

    public static ListNode removeDuplicateWithoutBuffer(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode listNode = node;
            while (listNode.next != null) {
                if (listNode.next.val == node.val) {
                    listNode.next = listNode.next.next;
                } else {
                    listNode = listNode.next;
                }
            }
            node = node.next;
        }
        return head;
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

        //RemoveDuplicate.removeDuplicateWithBuffer(list.head);
        RemoveDuplicate.removeDuplicateWithoutBuffer(list.head);
        printList(list);
    }
}
