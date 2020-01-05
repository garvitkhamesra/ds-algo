package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dot on 5/1/20 7:39 PM
 * Package: trees
 */
public class InOrderTraversalWithRecursion {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) return res;
        inOrderTraversal(root.left);
        res.add(root.val);
        inOrderTraversal(root.right);
        return res;
    }
}
