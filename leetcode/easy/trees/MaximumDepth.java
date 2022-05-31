package trees;

import easy.trees.TreeNode;

/**
 * Created by dot on 6/1/20 10:52 PM
 * Package: trees
 */
public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
