package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class CombinationSumII {
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
            if(i > index && arr.get(i) == arr.get(i-1)) continue; // skip duplicates
            sum += arr.get(i); subSum.add(arr.get(i));
            combinationSumSolver(arr, target, sum, i+1, result, subSum);
            sum -= arr.get(i); subSum.remove(subSum.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(); // [ 8, 10, 6, 11, 1, 16, 8 ]
        arr.add(15); //  15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17
        arr.add(8); arr.add(18);
        arr.add(15); arr.add(10);
        arr.add(10); arr.add(8);
        arr.add(19); arr.add(11);
        arr.add(7); arr.add(1);
        int sum = 17;
//        arr.add(8); arr.add(1);
//        arr.add(10); arr.add(8);
//        arr.add(6); arr.add(16);
//        arr.add(11);
//        int sum = 28;
        Collections.sort(arr);

        for (ArrayList<Integer> list : combinationSum(arr, sum)) {
            System.out.println(list);
        }

    }
}
