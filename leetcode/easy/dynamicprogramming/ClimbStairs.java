package dynamicprogramming;

/**
 * Created by dot on 13/1/20 7:06 AM
 * Package: dynamicprogramming
 */
public class ClimbStairs {

    // Recursion with memoization
    public int climbStairs(int n) {
        int [] memo = new int[n];
        return climb_stairs(0, n, memo);
    }

    public int climb_stairs(int l, int n,int[] memo) {
        if (n < l) {
            return 0;
        }
        if (n == l) {
            return 1;
        }
        if (memo[l] != 0) return memo[l];
        memo[l] = climb_stairs(l+1, n,memo) + climb_stairs(l+2, n,memo);
        return memo[l];
    }

    // USing DP
    public int climbStairsDP(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    // FB sols
    public int climbStairsFbNum(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    public int climbStairsFbFormula(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }
}

/*
Binet's method pending
https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/569/
*/
