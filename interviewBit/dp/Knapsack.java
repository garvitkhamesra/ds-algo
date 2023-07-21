package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack {
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        return knapsackSolver(A, B, C);
    }

    private static int knapsackSolver(ArrayList<Integer> a, ArrayList<Integer> b, int c) {
        int dp[][] = new int[a.size() + 1][c + 1];

        for (int i = 1; i <= a.size(); i++) {
            for (int j = 1; j <= c; j++) {
                if (b.get(i-1) > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(a.get(i-1) + dp[i-1][j - b.get(i-1)], dp[i-1][j]);
                }
            }
        }
        return dp[a.size()][c];
    }

    public static int knapsackSolverRecursion(ArrayList<Integer> a, ArrayList<Integer> b, int c, int n) {
        if (n == 0 || c == 0) {
            return 0;
        }
        if (b.get(n) > c) {
            return knapsackSolverRecursion(a, b, c, n-1);
        } else {
            return Math.max(knapsackSolverRecursion(a, b, c, n-1),
                    a.get(n) + knapsackSolverRecursion(a, b, c-b.get(n), n-1));
        }
    }

    private static int[][] dp;

    public static int knapsackSolverRecursionMemo(ArrayList<Integer> a, ArrayList<Integer> b, int c, int n, int[][] dp) {
        if (n == 0 || c == 0) {
            return 0;
        }
        if (dp[n][c] != -1) return dp[n][c];
        if (b.get(n) > c) {
            dp[n][c] = knapsackSolverRecursionMemo(a, b, c, n-1, dp);
        } else {
            dp[n][c] = Math.max(knapsackSolverRecursionMemo(a, b, c, n-1, dp),
                    a.get(n) + knapsackSolverRecursionMemo(a, b, c-b.get(n), n-1, dp));
        }

        return dp[n][c];
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(60, 100, 120));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(10, 20, 30));
        int C = 50;

        System.out.println(solve(A, B, C));
        System.out.println(knapsackSolverRecursion(A, B, C, A.size()-1));

        dp = new int[A.size()][C+1];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j <= C; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsackSolverRecursionMemo(A, B, C, A.size() - 1, dp));
    }
}
