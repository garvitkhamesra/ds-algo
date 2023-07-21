package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return helper(nums, -1, 0, dp);
    }

    private static int helper(int[] nums, int prev, int curr, int[][] dp) {
        if (curr == nums.length) {
            return 0;
        }

        if (dp[prev+1][curr] >= 0) {
            return dp[prev+1][curr];
        }

        int include = 0;
        if (prev < 0 || nums[prev] < nums[curr]) {
            include = 1 + helper(nums, curr, curr+1, dp);
        }

        int exclude = helper(nums, prev, curr+1, dp);

        dp[prev+1][curr] = Math.max(include, exclude);
        return dp[prev+1][curr];
    }

    public static void main(String[] args) {
        System.out.println(LongestIncreasingSubsequence.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }
}
