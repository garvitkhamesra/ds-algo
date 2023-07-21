package trees;

import easy.trees.TreeNode;

public class ConstructBSTFromPreOrder {
    public TreeNode constructBST(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode curr = root, prev = null;
            while (curr != null) {
                prev = curr;
                if (preorder[i] > curr.val)
                    curr = curr.right;
                else curr = curr.left;
            }
            if (prev.val < preorder[i])
                prev.right = new TreeNode(preorder[i]);
            else prev.left = new TreeNode(preorder[i]);
        }
        return root;
    }

    int i = 0;
    public TreeNode constructBSTRecursion(int[] preorder, int max) {
        if (i == preorder.length || preorder[i] > max) return null;

        TreeNode node = new TreeNode(preorder[i]);
        i++;
        node.left = constructBSTRecursion(preorder, node.val);
        node.right = constructBSTRecursion(preorder,max);
        return node;
    }
}
