package trees;

import easy.trees.TreeNode;

import java.util.ArrayList;
import java.util.TreeMap;

public class VerticalSumBinaryTree {
    public ArrayList<Integer> verticalSum(TreeNode A) {
        verticalSum(A, 0);
        return new ArrayList<Integer>(map.values());
    }

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    private void verticalSum(TreeNode node, int level) {
        if (node == null) return;
        if (map.containsKey(level)) {
            int t = map.get(level);
            map.put(level, t+node.val);
        } else {
            map.put(level, node.val);
        }

        verticalSum(node.left, level-1);
        verticalSum(node.right, level+1);
    }
}
