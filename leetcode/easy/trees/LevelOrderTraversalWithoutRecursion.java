package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dot on 6/1/20 12:22 AM
 * Package: trees
 */

public class LevelOrderTraversalWithoutRecursion {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (treeNodes.size() != 0) {
            List<Integer> subResult = new ArrayList<>();
            int s = treeNodes.size();
            for (int i = 0; i < s; i++) {
                TreeNode treeNode = treeNodes.poll();
                if (treeNode.left != null) treeNodes.add(treeNode.left);
                if (treeNode.right != null) treeNodes.add(treeNode.right);
                subResult.add(treeNode.val);
            }
            res.add(subResult);
        }
        return res;
    }
}

    /*List<List<Integer>> res = new ArrayList<>();  
    if (root == null) return res;
            Queue<TreeNode> treeNodes = new LinkedList<>();
    treeNodes.add(root);
    List<Integer> subResult = new ArrayList<>();
    while (treeNodes.size() != 0) {
    TreeNode treeNode = treeNodes.poll();
    if (treeNode.left != null) treeNodes.add(treeNode.left);
    if (treeNode.right != null) treeNodes.add(treeNode.right);
    subResult.add(treeNode.val);
    }
    System.out.println(subResult);
    return res;*/