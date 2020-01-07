package trees;

/**
 * Created by dot on 7/1/20 10:01 AM
 * Package: trees
 */
public class SymmetricTreeWithRecursion {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return (node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node2.left, node1.right));
    }
}
