package trees;

import easy.trees.TreeNode;

public class HeightOfBalancedTree {
    public int isBalanced(TreeNode A) {
        return height(A) != -1 ?1:0;
    }
    int height(TreeNode A) {
        if (A == null) {
            return 0;
        }

        int l = height(A.left);
        if (l == -1) return -1;
        int r = height(A.right);
        if (r == -1) return -1;
        if (Math.abs(l-r) > 1) return -1;
        return 1 + Math.max(l,r);
    }
}
