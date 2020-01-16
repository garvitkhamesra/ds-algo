package dynamicprogramming;

/**
 * Created by dot on 16/1/20 8:24 AM
 * Package: dynamicprogramming
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
