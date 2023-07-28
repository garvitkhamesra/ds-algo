package trees;

import easy.trees.TreeNode;

public class RemoveHalfNodes {
    public TreeNode solve(TreeNode A) {
        return solver(A);
    }

    private TreeNode solver(TreeNode a) {
        if (a == null) return null;
        if (a.left == null && a.right == null) return a;
        if (a.left != null && a.right == null) {
            return solver(a.left);
        } else if (a.right != null && a.left == null) {
            return solver(a.right);
        }
        a.left = solver(a.left);
        a.right = solver(a.right);
        return a;
    }
}
