package dp;

public class LongestIncreasingDecreasingSubsequenceCp {

    public static int longestSubsequenceLength(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] inc = new int[n];
        int[] dec = new int[n];

        for (int i = 0; i < n; i++) {
            inc[i] = increasingHelper(nums, i, inc);
            dec[i] = decreasingHelper(nums, i, dec);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, inc[i] + dec[i] - 1);
        }

        return max;
    }

    private static int increasingHelper(int[] nums, int end, int[] dp) {
        if (dp[end] > 0) {
            return dp[end];
        }

        int max = 0;
        for (int i = 0; i < end; i++) {
            if (nums[i] < nums[end]) {
                max = Math.max(max, increasingHelper(nums, i, dp));
            }
        }

        dp[end] = max + 1;
        return dp[end];
    }

    private static int decreasingHelper(int[] nums, int start, int[] dp) {
        if (dp[start] > 0) {
            return dp[start];
        }

        int max = 0;
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] < nums[start]) {
                max = Math.max(max, decreasingHelper(nums, i, dp));
            }
        }

        dp[start] = max + 1;
        return dp[start];
    }

    public static void main(String[] args) {
        System.out.println(LongestIncreasingDecreasingSubsequenceCp.longestSubsequenceLength(new int[] {1, 3, 5, 6, 4 ,8 ,4, 3, 2, 1}));
    }
}
