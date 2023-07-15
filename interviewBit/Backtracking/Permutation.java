package Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation {
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permuteSolver(A, 0, result);
        return result;
    }

    private static void permuteSolver(ArrayList<Integer> arr, int index, ArrayList<ArrayList<Integer>> result) {
        if (index == arr.size()) {
            result.add(new ArrayList<>(arr));
        }

        for (int i = index; i < arr.size(); i++) {
            Collections.swap(arr, i, index);
            permuteSolver(arr, index+1, result);
            Collections.swap(arr, index, i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1); arr.add(2); arr.add(3);

        for (ArrayList<Integer> integers : permute(arr)) {
            System.out.println(integers);
        }
    }
}
