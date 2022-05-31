//package Tree;
//
//import trees.TreeNode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BTRightView {
//    void getRightView(TreeNode node, int height, List<Integer> res) {
//        if(node == null) {
//            return;
//        }
//
//        if(height > res.size()) {
//            res.add(node.val);
//        }
//
//        getRightView(node.right, height + 1, res);
//        getRightView(node.left, height + 1, res);
//    }
//
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//
//        getRightView(root, 1, res);
//        return res;
//    }
//}
