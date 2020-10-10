package tree;

import trees.TreeNode;

public class ConstructBSTFromInOrderPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(0, 0, inorder.length -1, preorder, inorder);
    }

    static TreeNode construct(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (inStart > inEnd || preIndex >= preorder.length) return null;

        TreeNode root = new TreeNode(preorder[preIndex]);
        int mid = 0;
        for (int i = inStart; i <= inEnd; i++)
            if (inorder[i] == root.val) mid = i;

        root.left = construct(preIndex+1, inStart, mid-1, preorder, inorder);
        root.right = construct(preIndex + mid - inStart + 1, mid+1, inEnd, preorder, inorder);
        return root;
    }
}
