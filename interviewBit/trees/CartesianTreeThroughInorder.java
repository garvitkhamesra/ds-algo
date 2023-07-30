package trees;

import easy.trees.TreeNode;

import java.util.ArrayList;

public class CartesianTreeThroughInorder {
    public TreeNode buildTree(ArrayList<Integer> A) {
        return constructTree(A, 0, A.size()-1);
    }

    TreeNode constructTree(ArrayList<Integer> A, int start, int end) {
        if (start > end) return null;
        int max = Integer.MIN_VALUE, index = 0;

        for (int i = start; i <= end; i++) {
            if (max < A.get(i)) {
                max = A.get(i);
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = constructTree(A, start, index - 1);
        root.right = constructTree(A, index+1, end);

        return root;
    }
}
