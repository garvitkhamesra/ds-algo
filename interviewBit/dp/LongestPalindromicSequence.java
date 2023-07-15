package dp;

import java.util.Arrays;

public class LongestPalindromicSequence {
    public static int solve(String A) {
        return solve(A, new StringBuilder(A).reverse().toString());
    }

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


    static int[][] res;
    public static int solver(String A) {

        int len = A.length();
        res = new int[len][len];

        for (int i = 0; i < len; i++){
            Arrays.fill(res[i], -1);
        }

        res[0][len-1] = getLongest(A, 0, len-1);
        return res[0][len-1];
    }

    static int getLongest(String A, int start, int end){

        int len = A.length();

        if (start > end || start >= len){
            return 0;
        }

        if (start == end){
            res[start][end] = 1;
            return 1;
        }

        if (A.charAt(start)==A.charAt(end)) {
            int val = res[start+1][end-1];
            res[start][end] = 2 + ((val!=-1)?val: getLongest(A, start+1, end-1));
        } else {
            int val1 = res[start+1][end];
            int val2 = res[start][end-1];

            if(val1!=-1 && val2!=-1){
                res[start][end] = (int)Math.max(val1, val2);
            }else if(val1!=-1){
                res[start][end] = (int)Math.max(val1 , getLongest(A, start, end-1));
            }else if(val2!=-1){
                res[start][end] = (int)Math.max(getLongest(A, start+1, end) , val2);
            }else{
                res[start][end] = (int)Math.max(getLongest(A, start+1, end),getLongest(A, start, end-1));
            }
        }

        return res[start][end];

    }

    public static void main(String[] args) {
        System.out.println(solve("abbcdgf"));
    }
}
