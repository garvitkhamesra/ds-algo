package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dot on 5/1/20 8:42 PM
 * Package: trees
 */
public class PreOrderTraversalWithoutRecursion {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) return res;
        TreeNode curr = root;
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(curr);
        while (!treeNodes.empty()) {
            TreeNode treeNode = treeNodes.pop();
            res.add(treeNode.val);
            if (treeNode.right != null) treeNodes.push(treeNode.right);
            if (treeNode.left != null) treeNodes.push(treeNode.left);
        }
        return res;
    }
}
