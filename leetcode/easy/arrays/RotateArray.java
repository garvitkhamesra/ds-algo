package easy.arrays;

/**
 * User: garvit
 * Date: 19/12/19 8:43 AM
 */

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
Rotate Array
*/
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        if (k > nums.length) k = k % nums.length;
        int l = 0, r = nums.length - k - 1;
        if (nums.length == 1 || k == 0 || nums.length == 0) return;
        while (l < r) {
            nums = swap(nums, l, r);
            l++;r--;
        }
        l = nums.length - k;
        r = nums.length - 1;
        while (l < r) {
            nums = swap(nums, l, r);
            l++;r--;
        }

        l = 0;
        r = nums.length - 1;
        while (l < r) {
            nums = swap(nums, l, r);
            l++;r--;
        }
    }

    private int[] swap(int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
        return n;
    }
}

/*
Method 2
Extra Array
public class Solution {
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}

Method 3
Using Cyclic Replacements
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}*/
