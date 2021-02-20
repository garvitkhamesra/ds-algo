package Tree;

import trees.TreeNode;

import java.util.ArrayList;

public class BTLeftView {
    ArrayList<Integer> leftView(TreeNode root)
    {
        ArrayList<Integer> res = new ArrayList<Integer> ();
        leftViewUtil(root, res, 1);
        return res;
    }
    // recursive function to print left view
    void leftViewUtil(TreeNode node, ArrayList<Integer> res, int level)
    {
        if (node == null)
            return;
        if (res.size() < level) {
            res.add(node.val);
        }
        leftViewUtil(node.left,res, level + 1);
        leftViewUtil(node.right,res, level + 1);
    }
}
