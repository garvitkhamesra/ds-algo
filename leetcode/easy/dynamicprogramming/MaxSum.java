package dynamicprogramming;

/**
 * Created by dot on 16/1/20 8:23 AM
 * Package: dynamicprogramming
 */
public class MaxSum {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            ans = Math.max(sum, ans);
        }

        return ans;
    }
}
