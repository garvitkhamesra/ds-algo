package week3;

import trees.TreeNode;

/**
 * Created by dot on 20/4/20 8:13 PM
 * Package: week3
 */
public class PreOrderBSTCreation {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = construct(root, preorder[i]);
        }

        return root;
    }

    public TreeNode construct(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) {
            root.left = construct(root.left, val);
        } else {
            root.right = construct(root.right, val);
        }
        return root;
    }
}