package easy.arrays;

/**
 * User: garvit
 * Date: 19/12/19 8:41 AM
 */

/*
Remove Duplicates from Sorted Array
https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
*/

public class DuplicatesInSortedArray {
    public int removeDuplicates(int[] nums) {
        int z = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[z++] = nums[i+1];
            }
        }
        return z;
    }
}

