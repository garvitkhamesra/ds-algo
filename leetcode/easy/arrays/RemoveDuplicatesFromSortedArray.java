package arrays;

/**
 * Created by dot on 1/7/20 11:20 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (i < nums.length - 1) {
            if(nums[i] != nums[i+1]) {
                nums[j] = nums[i+1];
                j++;
            }
            i++;
        }
        return j;
    }
}
