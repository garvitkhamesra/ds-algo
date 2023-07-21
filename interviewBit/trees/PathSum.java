package trees;

import easy.trees.TreeNode;

public class PathSum {
    public int hasPathSum(TreeNode A, int B) {
        return solve(A, B) ? 1 : 0;
    }

    int sum = 0;
    private boolean solve(TreeNode a, int b) {
        if (a == null) {
            return false;
        }
        sum += a.val;
        if (a.left == null && a.right == null && sum == b) {
            return true;
        }
        boolean l = solve(a.left, b);
        boolean r = solve(a.right, b);

        if (l || r) {
            return true;
        } else {
            sum -= a.val;
            return false;
        }
    }
}
