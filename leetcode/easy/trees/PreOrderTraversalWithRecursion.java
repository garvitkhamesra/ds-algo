package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dot on 5/1/20 8:42 PM
 * Package: trees
 */
public class PreOrderTraversalWithRecursion {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) return res;
        res.add(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        return res;
    }
}
