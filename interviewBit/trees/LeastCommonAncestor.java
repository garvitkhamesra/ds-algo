package trees;

import easy.trees.TreeNode;

public class LeastCommonAncestor {

    public int lca(TreeNode A, int B, int C) {
        if(!find(A, B) || !find(A, C)) return -1;
        return lowestCommonAncestor(A, B, C).val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode forLeft = lowestCommonAncestor(root.left,p,q);
        TreeNode forRight = lowestCommonAncestor(root.right,p,q);
        if(forLeft==null) return forRight;
        if(forRight==null) return forLeft;

        return root;
    }
    public boolean find(TreeNode root, int val){
        if(root == null) return false;
        if(root.val == val) return true;
        return find(root.left, val) || find(root.right, val);
    }

}
