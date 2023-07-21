package trees;

import easy.trees.TreeNode;

import java.util.*;

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
    public ArrayList<Integer> postorderTraversalCollections(TreeNode A) {
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        s.add(A);
        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            res.add(node.val);
            if (node.left != null) s.push(node.left);
            if (node.right != null) s.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }
}
