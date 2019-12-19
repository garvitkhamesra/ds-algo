package easy.arrays;

import java.util.HashMap;

/**
 * User: garvit
 * Date: 19/12/19 9:10 AM
 */

/*
Two Sum
https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
*/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}


/*
    public int[] twoSum(int[] num, int target) {
         HashMap<Integer, Integer> compliment = new HashMap<>();
         for (int i = 0; i < num.length; i++) {
             if (compliment.containsValue(num[i])) {

                 return new int[] {num[i]}
             }
             compliment.put(i, target-num[i]);
         }
         return new int[]{};
     }
*/
