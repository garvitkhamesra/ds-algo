package trees;

import easy.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cousins {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> v = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        boolean m = true;
        while (!q.isEmpty() && m) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = q.poll();
                if ((t.left != null && t.left.val == B) || (t.right != null && t.right.val == B))
                    m = false;
                else {
                    if (t.left != null) q.add(t.left);
                    if (t.right != null) q.add(t.right);
                }
            }
        }
        while (!q.isEmpty()) {
            v.add(q.poll().val);
        }
        return v;
    }
}
