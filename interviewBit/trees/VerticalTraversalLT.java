package trees;

import easy.trees.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class VerticalTraversalLT {
    public ArrayList<ArrayList<Integer>> verticalTraversal(TreeNode root) {
        // < col, < row, val > >
        TreeMap<Integer, ArrayList<Pair<Integer, Integer>>> map = new TreeMap<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // build the map -> O(NlogN) for sorting column index (worst case)
        preorder(map, root, 0, 0);

        // use the map to build the result, O(NlogN) for sorting row index (worst case)
        for(int key : map.keySet()){
            ArrayList<Pair<Integer, Integer>> colList = map.get(key);
            // sort colList by row index(if rows are equal, sort by value)
            Collections.sort(colList, (a,b) -> a.getKey().compareTo(b.getKey()) == 0 ?
                    a.getValue().compareTo(b.getValue()) : a.getKey().compareTo(b.getKey()));
            // add current column's elements into list
            ArrayList<Integer> colRes = new ArrayList<>();
            for(Pair<Integer, Integer> pair : colList){
                colRes.add(pair.getValue());
            }
            res.add(colRes);
        }

        return res;
    }

    private void preorder(TreeMap<Integer, ArrayList<Pair<Integer, Integer>>> map,
                          TreeNode node, int row, int col){
        if(node == null) return;

        // new col
        if(!map.containsKey(col)){
            map.put(col, new ArrayList<>());
        }
        // add new node into list according to the column
        map.get(col).add(new Pair(row, node.val));

        // dfs
        preorder(map, node.left, row + 1, col - 1);
        preorder(map, node.right, row + 1, col + 1);
    }
}
