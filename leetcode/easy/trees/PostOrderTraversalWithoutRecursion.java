package trees;

import easy.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dot on 5/1/20 8:54 PM
 * Package: trees
 */
public class PostOrderTraversalWithoutRecursion {
    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) return res;
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.pop();
            res.addFirst(treeNode.val);
            if (treeNode.left != null) treeNodes.push(treeNode.left);
            if (treeNode.right != null) treeNodes.push(treeNode.right);
        }
        return res;
    }
}
