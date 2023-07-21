package trees;

import easy.trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZag {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        int j = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sub.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            j++;
            if (j%2 == 0) {
                Collections.reverse(sub);
            }
            result.add(sub);
        }

        return result;
    }
}
