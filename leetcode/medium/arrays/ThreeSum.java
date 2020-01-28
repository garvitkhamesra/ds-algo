package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dot on 27/1/20 8:28 AM
 * Package: PACKAGE_NAME
 */
public class ThreeSum {

    // Without duplicate
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1, k = nums.length-1;
            if (i == 0 || (i > 0 && nums[i-1]!=nums[i])) { // so that it can skip the 3rd num
                while (j < k) {
                    int sum = nums[i] + nums[k] + nums[j];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j+1]) j++; // so that it can skip the other 2 num
                        while (j < k && nums[k-1] == nums[k]) k--;
                        j++;k--;
                    }
                    else if (sum < 0) j++;
                    else k--;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
