package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dot on 5/1/20 8:55 PM
 * Package: trees
 */
public class PostOrderTraversalWithRecursion {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) return res;
        res.addAll(postOrderTraversal(root.left));
        res.addAll(postOrderTraversal(root.right));
        res.add(root.val);
        return res;
    }
}
