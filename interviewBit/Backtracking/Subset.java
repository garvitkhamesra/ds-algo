package Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        subsets(A, 0, new ArrayList<>(), result);
        return result;
    }

    private static void subsets(ArrayList<Integer> arr, int ind, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i = ind; i < arr.size(); i++) {
            subset.add(arr.get(i));
            subsets(arr, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        ArrayList<ArrayList<Integer>> subsets = subsets(arr);
        for (ArrayList<Integer> a: subsets) {
            System.out.println(a);
        }
    }
}
