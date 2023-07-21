package trees;

import easy.trees.TreeNode;

import java.util.ArrayList;

public class PathToNode {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        solve(A, B, result);
        return result;
    }

    private boolean solve(TreeNode A, int B, ArrayList<Integer> result) {
        if (A == null) return false;
        result.add(A.val);
        if (A.val == B) {
            return true;
        }
        boolean left = solve(A.left, B, result);

        boolean right = solve(A.right, B, result);

        if (left || right) {
            return true;
        } else {
            if (result.size() > 0) result.remove(result.size() - 1);
            return false;
        }
    }
}
