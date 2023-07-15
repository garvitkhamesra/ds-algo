package tree;

import java.util.List;

public class ConstructBSTFromInOrder {
    public static BST minHeightBst(List<Integer> array) {
        return create(array, null , 0, array.size()-1);
    }

    static BST create(List<Integer> arr, BST tree, int l , int r) {
        if (l <= r) {
            int mid = (l+r)/2;
            if (tree == null) tree = new BST(arr.get(mid));
            else tree.insert(arr.get(mid));
            create(arr, tree, l, mid-1);
            create(arr, tree, mid+1, r);
            return tree;
        }
        return null;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
