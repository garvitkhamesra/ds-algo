package trees;

import easy.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {

    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        q.add(A);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            while (node != null) {
                if (node.left != null) q.add(node.left);
                result.add(node.val);
                node = node.right;
            }

        }
        return result;
    }
}
