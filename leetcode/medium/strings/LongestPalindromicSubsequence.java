package strings;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] memo = new int[s.length()][s.length()];
        return palLength(s, 0, s.length()-1, memo);
    }

    public int palLength (String str, int i, int j, int[][] memo) {
        if (i == j) return 1;
        if (i > j) return 0;

        if (memo[i][j] != 0) return memo[i][j];

        if (str.charAt(i) == str.charAt(j)) {
            memo[i][j] = palLength(str, i+1, j-1, memo) + 2;
            return memo[i][j];
        } else {
            int l1 = palLength(str, i+1, j, memo);
            int l2 = palLength(str, i, j-1, memo);
            memo[i][j] = Math.max(l1, l2);
            return memo[i][j];
        }
    }

    public int tabulation(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
