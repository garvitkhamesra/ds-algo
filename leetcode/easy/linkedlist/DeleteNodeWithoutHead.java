package linkedlist;

/**
 * User: garvit
 * Date: 20/12/19 7:47 AM
 */

/*
Delete Node Without Head
https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/
*/


public class DeleteNodeWithoutHead {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
