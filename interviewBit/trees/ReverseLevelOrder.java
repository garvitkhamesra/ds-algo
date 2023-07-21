package trees;

import easy.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        Stack<TreeNode> s = new Stack<>();

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            s.add(node);
            // if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
            if (node.left != null) q.add(node.left);

        }

        while (!s.isEmpty()) result.add(s.pop().val);

        return result;
    }

}
