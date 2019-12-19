package easy.arrays;

import java.util.HashSet;

/**
 * User: garvit
 * Date: 19/12/19 9:05 AM
 */

/*
import java.util.HashSet;Contains Duplicate
https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
*/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
