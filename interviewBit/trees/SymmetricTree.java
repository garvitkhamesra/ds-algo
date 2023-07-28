package trees;

import easy.trees.TreeNode;

public class SymmetricTree {
    public int isSymmetric(TreeNode A) {
        if (A.left == null && A.right == null) return 1;
        if (A.left == null || A.right == null) return 0;
        return solve(A.left, A.right) ? 1 : 0;
    }

    public boolean solve(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.val != b.val) return false;
        return solve(a.left, b.right) && solve(a.right, b.left);
    }
}
