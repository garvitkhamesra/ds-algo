package tree;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res.size() < k ? -1 : res.get(k-1);
    }

    static void inorder(TreeNode root, List arr) {
        if (root != null) {
            inorder(root.left, arr);
            arr.add(root.val);
            inorder(root.right, arr);
        }
    }
}
