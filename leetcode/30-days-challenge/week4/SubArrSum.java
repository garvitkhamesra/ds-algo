package week4;

import java.util.HashMap;

/**
 * Created by dot on 22/4/20 7:09 PM
 * Package: week4
 */
public class SubArrSum {
    /*
    * https://leetcode.com/problems/subarray-sum-equals-k/
    * */

    // O(N^2)
    public int subArraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result ++;
                    continue;
                }
            }
        }

        return result;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
