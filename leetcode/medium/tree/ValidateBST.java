package tree;

public class ValidateBST {
    public static boolean validateBst(BST tree) {
        return validate(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean validate(BST tree, int min, int max) {
        if (tree != null && tree.value < min || tree.value >= max) return false;
        if (tree.left != null && !validate(tree.left, min, tree.value)) return false;
        if (tree.right != null && !validate(tree.right, tree.value, max)) return false;
        return true;
    }
}
