package trees;

import easy.trees.TreeNode;

public class MinDepth {
    public int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode A) {
        if (A == null) return 0;
        solve(A, 1);
        return min;
    }

    public void solve(TreeNode a, int level) {
        if (a.left == null && a.right == null) {
            min = Math.min(level, min);
            return;
        }
        if (a.left != null) solve(a.left, level +1);
        if (a.right != null) solve(a.right, level +1);
    }
}
