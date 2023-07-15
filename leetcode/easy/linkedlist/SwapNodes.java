package easy.linkedlist;

import chapter2.LinkedList;

import static chapter2.LinkedList.insert;
import static chapter2.LinkedList.printList;

public class SwapNodes {
    public static linkedlist.ListNode swapPairs(linkedlist.ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        linkedlist.ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList list = new LinkedList();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        printList(list.head);

        swapPairs(list.head);
        printList(list.head);

    }
}