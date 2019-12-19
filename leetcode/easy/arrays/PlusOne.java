package easy.arrays;

/**
 * User: garvit
 * Date: 19/12/19 9:08 AM
 */

/*
Add One
https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
*/

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1, n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            if (temp < 10) {
                digits[i] = temp;
                carry = 0;
            } else {
                digits[i] = 0;
            }
            if (carry == 0) break;
        }
        if (carry == 1) {
            int[] ans = new int[n+1];
            ans[0] = 1;
            for (int i = 0; i < n; i++) {
                ans[i+1] = digits[i];
            }
            return ans;
        }
        return digits;
    }
}
