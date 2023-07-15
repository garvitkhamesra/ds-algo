package chapter2;

import linkedlist.ListNode;

import static chapter2.LinkedList.printList;

public class Intersection {
    public static ListNode getIntersection(ListNode first, ListNode second) {
        int len1 = getLength(first);
        int len2 = getLength(second);
        int diff = 0;
        if (len1 < len2) {
            diff =  len2 - len1;
            while (diff > 0) {
                second = second.next;
                diff--;
            }
        }
        else if (len2 < len1) {
            diff = len1 - len2;
            while (diff > 0) {
                first = first.next;
                diff--;
            }
        }

        while (first != null && second != null) {
            if (first == second) return first;
            first = first.next;
            second = second.next;
        }
        return null;
    }

    private static int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
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
        ListNode listNode = getIntersection(first.head, second.head);
        if (listNode == null) System.out.println("No intersection");
        else System.out.println(listNode.val);
    }
}
