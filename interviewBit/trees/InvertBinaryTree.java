package trees;

import easy.trees.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode A) {
        if (A == null) return null;

        TreeNode n = A;
        TreeNode l = invertTree(A.left);
        TreeNode r = invertTree(A.right);

        n.right = l;
        n.left = r;

        return n;
    }
}
