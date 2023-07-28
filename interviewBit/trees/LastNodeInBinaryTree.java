package trees;

import easy.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LastNodeInBinaryTree {
    public int lastNode(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sub.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            result.add(sub);
        }
        ArrayList<Integer> s = result.get(result.size() - 1);
        return s.get(s.size() - 1);
    }

    int height(TreeNode A){
        if(A == null)
            return 0;
        return Math.max(height(A.left),height(A.right))+1;
    }
    public int lastNodeR(TreeNode A) {
        if(A.left==null && A.right==null)
            return A.val;

        int lH = height(A.left);
        int rH = height(A.right);

        return lH > rH ? lastNodeR(A.left) : lastNodeR(A.right);
    }
}
