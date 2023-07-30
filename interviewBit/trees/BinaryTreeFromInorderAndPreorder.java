package trees;

import easy.trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderAndPreorder {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.size(); i++) {
            map.put(B.get(i), i);
        }

        return constructTree(A, 0, A.size()-1, map);
    }

    int index = 0;
    TreeNode constructTree(ArrayList<Integer> A, int start, int end, Map<Integer, Integer> map) {
        if (start > end || index >= A.size()) return null;

        TreeNode root = new TreeNode(A.get(index));
        index++;
        root.left = constructTree(A, start, map.get(root.val) - 1, map);
        root.right = constructTree(A, map.get(root.val) + 1, end, map);

        return root;
    }
}
