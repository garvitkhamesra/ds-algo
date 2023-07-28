package trees;

import easy.trees.TreeNode;

public class IdenticalTree {
    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) return 1;
        if (A == null || B == null) return 0;
        if (A.val != B.val) return 0;
        return ((isSameTree(A.left, B.left) == 1) && (isSameTree(A.right, B.right) == 1)) ? 1 : 0 ;
    }
}
