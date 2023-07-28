package trees;

import easy.trees.TreeNode;

import java.util.*;

public class VerticalTraversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        if(A == null) return ans;
        queue.add(new Pair(0, A));
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            ArrayList<Integer> temp = map.get(curr.hd);
            if(temp == null) {
                temp = new ArrayList<>();
                temp.add(curr.node.val);
            } else temp.add(curr.node.val);
            map.put(curr.hd, temp);
            if(curr.node.left != null) queue.add(new Pair(curr.hd - 1, curr.node.left));
            if(curr.node.right != null) queue.add(new Pair(curr.hd + 1, curr.node.right));
        }
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) ans.add(entry.getValue());
        return ans;
    }
    // I had made my own class "Pair" because i want to get
    // horizontal distance = "hd" & reference of Node = "node"
    static class Pair{
        int hd;
        TreeNode node;
        Pair(int hd,TreeNode node){
            this.hd =  hd;
            this.node = node;
        }
    }
}
