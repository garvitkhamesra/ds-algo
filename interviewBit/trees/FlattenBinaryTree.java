package trees;

import easy.trees.TreeNode;

import java.util.Stack;

public class FlattenBinaryTree {

    public void flattenIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode node = root;

        while (node != null) {

            // If the node has a left child
            if (node.left != null) {

                // Find the rightmost node
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // rewire the connections
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }

            // move on to the right side of the tree
            node = node.right;
        }
    }

    public void flattenIterativeStack(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode n = s.pop();
            if (n.right != null) s.push(n.right);
            if (n.left != null) s.push(n.left);

            if (!s.isEmpty()) n.right = s.peek();
            n.left = null;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }
}
