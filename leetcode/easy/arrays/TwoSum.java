package easy.arrays;

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


    /*// one pass solution
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> compliment = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (compliment.containsKey(nums[i])) {
                return new int[] {compliment.get(nums[i]), i};
            }
            compliment.put((target-nums[i]), i);
        }

        return new int[] {};
    }

    // two pass solution
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }*/