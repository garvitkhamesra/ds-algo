package tree;

import java.util.*;

class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
    }

    public BST insert(int value) {
        if (this.value > value) {
            if (this.left != null) {
                left.insert(value);
            } else {
                left = new BST(value);
            }
        } else {
            if (this.right != null) {
                right.insert(value);
            } else {
                right = new BST(value);
            }
        }
        return this;
    }

    public boolean contains(int value) {
        if (this.value > value) {
            if (this.left != null) {
                return left.contains(value);
            } else {
                return false;
            }
        } else if (this.value == value) {
            return true;
        }else {
            if (this.right != null) {
                return right.contains(value);
            } else {
                return false;
            }
        }
    }

    public BST remove(int value) {
        remove(value, null);
        return this;
    }

    public void remove (int value, BST parent) {
        if (value < this.value) {
            if (left != null) {
                left.remove(value, this);
            }
        } else if (value > this.value) {
            if (right != null) {
                right.remove(value, this);
            }
        }else {
            if (left !=null && right != null) {
                this.value = right.getMinValue();
                right.remove(this.value, this);
            } else if (parent == null) {
                if (left!= null) {
                    this.value = left.value;
                    right = left.right;
                    left = left.left;
                } else if (right != null) {
                    this.value = right.value;
                    left = right.left;
                    right = right.right;
                } else {}
            } else	if (parent.left == this) {
                parent.left = left!= null ? left:right;
            } else if (parent.right == this) {
                parent.right = left != null ? left : right;
            }

        }
    }

    public int getMinValue() {
        if (left == null) {
            return this.value;
        } else {
            return left.getMinValue();
        }
    }
}
