package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class CombinationSum {
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combinationSumSolver(A, B, 0, 0, result, new ArrayList<>());
        return result;
    }

    public static void combinationSumSolver(ArrayList<Integer> arr, int target, int sum, int index,
                                                              ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subSum) {
        if (target < sum) return;
        if (target == sum) {
            result.add(new ArrayList<>(subSum));
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            sum += arr.get(i); subSum.add(arr.get(i));
            combinationSumSolver(arr, target, sum, i, result, subSum);
            sum -= arr.get(i); subSum.remove(subSum.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(); // [ 8, 10, 6, 11, 1, 16, 8 ]
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        int sum = 5;
//        arr.add(8); arr.add(1);
//        arr.add(10); arr.add(8);
//        arr.add(6); arr.add(16);
//        arr.add(11);
//        int sum = 28;
        Collections.sort(arr);
        ArrayList<Integer> arrL = (ArrayList<Integer>) arr.stream().distinct().collect(Collectors.toList());

        for (ArrayList<Integer> list : combinationSum(arrL, sum)) {
            System.out.println(list);
        }

    }
}
