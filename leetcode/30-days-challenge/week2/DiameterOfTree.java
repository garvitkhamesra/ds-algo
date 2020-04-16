package week2;

import trees.TreeNode;

/**
 * Created by dot on 11/4/20 5:43 PM
 * Package: PACKAGE_NAME
 */
public class DiameterOfTree {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
    }

    public static int diameter(TreeNode root) {
        if (root == null) return 0;

        int heightL = height(root.left);
        int heightR = height(root.right);

        int daiR = diameter(root.right);
        int daiL = diameter(root.left);

        return Math.max(heightR + heightL, Math.max(daiR, daiL));
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    /*
    * O(N)*/
    /*int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }*/
}
