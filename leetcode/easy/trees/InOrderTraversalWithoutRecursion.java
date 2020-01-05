package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dot on 5/1/20 7:39 PM
 * Package: trees
 */
public class InOrderTraversalWithoutRecursion {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) return res;
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        TreeNode curr = root;
        while (!treeNodes.isEmpty()) {
            while (curr.left != null) {
                treeNodes.push(curr.left);
                curr = curr.left;
            }
            TreeNode treeNode = treeNodes.pop();
            res.add(treeNode.val);
            if (treeNode.right != null) {
                treeNodes.push(treeNode.right);
                curr = treeNode.right;
            }
        }
        return res;
    }
}
