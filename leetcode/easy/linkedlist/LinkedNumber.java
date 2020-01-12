package linkedlist;

/**
 * Created by dot on 12/1/20 12:12 PM
 * Package: linkedlist
 */
public class LinkedNumber {
    public int getDecimalValue(ListNode head) {
        String str = "";
        ListNode node = head;
        while (node != null) {
            str += node.val;
            node = node.next;
        }

        int res = 0;
        int n = str.length() - 1;
        for (int i = 0; i <= n; i++) {
            if (str.charAt(i) == '1') {
                res += Math.pow(2, n-i);
            }
        }
        return res;
    }
}
