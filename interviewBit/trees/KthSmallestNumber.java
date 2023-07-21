package trees;

import easy.trees.TreeNode;

import java.util.ArrayList;

public class KthSmallestNumber {

    public int kthsmallest(TreeNode A, int B) {
        ArrayList<Integer> ino = new ArrayList<Integer>();
        kthsmallestSolver(A, ino);
        for (int a: ino) {
            System.out.println(a);
        }
        return ino.get(B);
    }

    private void kthsmallestSolver(TreeNode node, ArrayList<Integer> inorder) {
        if (node == null) return;

        kthsmallestSolver(node.left, inorder);
        inorder.add(node.val);
        kthsmallestSolver(node.right, inorder);
    }


}
