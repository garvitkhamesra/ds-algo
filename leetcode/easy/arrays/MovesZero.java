package easy.arrays;

/**
 * User: garvit
 * Date: 19/12/19 9:09 AM
 */

/*
Move Zero
https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
*/

public class MovesZero {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[j++] = nums[i];
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
