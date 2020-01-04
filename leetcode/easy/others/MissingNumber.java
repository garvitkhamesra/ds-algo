package easy.others;

/**
 * User: garvit
 * Date: 04/01/20 3:47 PM
 */

/*
Missing number from 0 to n
https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/722/
*/

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }
}

/*2nd approach is take sum and find out, hashset and sorting are other.*/
