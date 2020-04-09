import linkedlist.ListNode;

/**
 * Created by dot on 8/4/20 1:03 PM
 * Package: PACKAGE_NAME
 */
public class MiddleElement {
    /*
    * First Approach - O(N)
    */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        int n = 0;
        while (fast != null) {
            fast = fast.next;
            n++;
        }
        n = n/2;

        while (n > 0) {
            slow = slow.next;
            n--;
        }
        return slow;
    }

    /*Second Approach 1 pass*/

    /*public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }*/

}
