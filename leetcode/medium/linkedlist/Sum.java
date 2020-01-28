package linkedlist;

/**
 * Created by dot on 28/1/20 9:46 AM
 * Package: linkedlist
 */
public class Sum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dum = new ListNode(0);
        ListNode dummy = dum;
        int c = 0;
        while (l1 != null || l2 != null) {
            int x = 0, y = 0;
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
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
            System.out.println(node.val);
            dummy.next = node;
            dummy = dummy.next;
        }
        if (c == 1) {
            dummy.next = new ListNode(1);
            dummy = dummy.next;
        }
        return dum.next;
    }
}