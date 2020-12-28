package level2;

public class ClimbingStairs {
    /*
    * reason is because u can climb only 1 or 2
    * */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int climbStairsFib(int A) {
        if (A == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= A; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
