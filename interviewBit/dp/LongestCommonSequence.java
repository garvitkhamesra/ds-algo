package dp;

import java.util.Arrays;

public class LongestCommonSequence {
    public static int solve(String A, String B) {
        int n = A.length()+1, m = B.length() + 1;
        int[][] dp = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A.charAt(j-1) == B.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    private static int helper(String s1 , String s2 , int i , int j , int[][]dp){

        if(i < 0 || j<0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = helper(s1 , s2 , i-1 , j-1 , dp)+1;
        }
        else{
            return dp[i][j] = Math.max(helper(s1, s2 ,i-1 ,j , dp) , helper(s1 , s2 , i , j-1 , dp));
        }

    }

    public static int solver(String A, String B) {

        int i = A.length()-1;
        int j = B.length()-1;

        int[][]dp = new int[i+1][j+1];
        for(int []a:dp){
            Arrays.fill(a , -1);
        }

        return helper(A , B , i , j , dp);
    }

    public static void main(String[] args) {
        System.out.println(solve("abbcdgf", "bbadcgf"));
        System.out.println(solver("abbcdgf", "bbadcgf"));
    }
}
