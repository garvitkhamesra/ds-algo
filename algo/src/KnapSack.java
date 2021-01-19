import java.util.Arrays;

public class KnapSack {

    static int[][] dp = new int[1000][1000];
    int knapsack(int[] arr, int[] wgt, int w, int n) {
        if (w <= 0 || n <= 0) {
            return 0;
        }
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        if (wgt[n-1] > w) {
            dp[n][w] = knapsack(arr, wgt, w, n-1);
        } else {
            dp[n][w] = Math.max(arr[n-1] + knapsack(arr, wgt, w - wgt[n-1], n-1),
                    knapsack(arr, wgt, w, n-1));
        }
        return dp[n][w];
    }

    int knapsackTopDown(int[] arr, int[] wgt, int w, int n) {
        int[][] top = new int[n][w];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 || j == 0) top[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wgt[i-1] > j) {
                    top[i][j] = top[i-1][j];
                } else {
                    top[i][j] = Math.max(arr[i-1] + top[i-1][j - wgt[n-1]], top[i-1][j]);
                }
            }
        }
        return top[n][w];
    }

    public static void main(String[] args) {
        Arrays.fill(dp, -1);
    }
}
