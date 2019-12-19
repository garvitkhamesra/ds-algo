package easy.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * User: garvit
 * Date: 19/12/19 9:06 AM
 */

/*
Single Number
https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
*/

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
