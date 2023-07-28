package trees;

import easy.trees.TreeNode;

public class MergeTwoBinaryTree {
    public TreeNode solve(TreeNode A, TreeNode B) {
        if (A == null && B == null) return null;
        if (A == null) return B;
        if (B == null) return A;
        TreeNode n = new TreeNode(A.val + B.val);
        TreeNode l = solve(A.left, B.left);
        TreeNode r = solve(A.right, B.right);
        n.left = l;
        n.right = r;
        return n;
    }
}
