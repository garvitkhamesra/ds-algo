package trees;

import easy.trees.TreeNode;

public class MaxDepth {
    public int maxDepth(TreeNode A) {
        if (A == null) return 0;
        return 1 + Math.max(maxDepth(A.left), maxDepth(A.right));
    }
}
