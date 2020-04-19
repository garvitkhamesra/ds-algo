/**
 * Created by dot on 18/4/20 10:59 PM
 * Package: PACKAGE_NAME
 */
public class MinValPostStep {
    public int minStartValue(int[] nums) {
        int val = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 1) {
                val += 1 - sum;
                sum = 1;
            }
        }
        return val == 0? 1 : val;
    }
}
