package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dot on 7/1/20 10:54 AM
 * Package: trees
 */
public class ValidateBSTWithBFS {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        ValidateBSTWithBFS validateBSTWithBFS = new ValidateBSTWithBFS();
        List<Integer> re = validateBSTWithBFS.inOrderTraversal(root);
        for (int i = 1; i < re.size(); i++) {
            if (re.get(i-1) >= re.get(i)) return false;
        }
        return true;
    }
    List<Integer> res = new ArrayList<>();

    public List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) return res;
        inOrderTraversal(root.left);
        res.add(root.val);
        inOrderTraversal(root.right);
        return res;
    }
}
