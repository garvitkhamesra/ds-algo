package trees;

import easy.trees.TreeNode;

public class ConsecutiveParentAndChild {
    int c = 0;
    public int consecutiveNodes(TreeNode A) {
        solve(A, A);
        return c;
    }

    private void solve(TreeNode node, TreeNode parent) {
        if (node == null || parent == null) return;
        if (Math.abs(node.val - parent.val) == 1) c++;
        solve(node.left, node);
        solve(node.right, node);
    }
}
