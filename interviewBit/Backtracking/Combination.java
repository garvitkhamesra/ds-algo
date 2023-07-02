package Backtracking;

import java.util.ArrayList;

public class Combination {
    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combineSolver(A, B, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private static void combineSolver(int a, int b, int n, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> result) {
        if (subset.size() == b) {
            result.add(new ArrayList<>(subset));
        }
        for (int i = n; i <= a; i++) {
            subset.add(i);
            combineSolver(a, b, i + 1, subset, result);
            subset.remove(subset.size() - 1);

        }
    }

    public static void main(String[] args) {
        for (ArrayList<Integer> list : combine(4, 2)) {
            System.out.println(list);
        }

    }
}
