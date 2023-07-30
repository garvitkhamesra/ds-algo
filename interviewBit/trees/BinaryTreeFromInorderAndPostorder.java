package trees;

import easy.trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderAndPostorder {
    public TreeNode buildTree(ArrayList<Integer> B, ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.size(); i++) {
            map.put(B.get(i), i);
        }
        index = A.size() - 1;
        return constructTree(A, 0, A.size()-1, map);
    }

    int index;
    TreeNode constructTree(ArrayList<Integer> A, int start, int end, Map<Integer, Integer> map) {
        if (start > end || index < 0) return null;

        TreeNode root = new TreeNode(A.get(index));
        index--;
        root.right = constructTree(A, map.get(root.val) + 1, end, map);
        root.left = constructTree(A, start, map.get(root.val) - 1, map);

        return root;
    }
}
