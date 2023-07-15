package dp;

public class EditDistance {
    public int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(A.toCharArray(), B.toCharArray(), n, m, dp);
    }

    private int solve(char[] a, char[] b, int n, int m, int[][] dp) {
        if (n == 0) return m;
        if (m == 0) return n;

        if (dp[n][m] != -1) return dp[n][m];


        if (a[n-1] == b[m-1]) {
            dp[n][m] = solve(a, b, n - 1, m - 1, dp);
        } else {
            dp[n][m] = 1 + Math.min(
                    solve(a, b, n - 1, m - 1, dp),
                    Math.min(
                            solve(a, b, n - 1, m, dp),
                            solve(a, b, n, m - 1, dp)
                    ));
        }

        return dp[n][m];
    }
}
