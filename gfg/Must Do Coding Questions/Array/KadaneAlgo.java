package Array;

import java.util.Arrays;
import java.util.List;

public class KadaneAlgo {
    public static long maxSubarraySum(int arr[], int n) {
        long sum = 0, s = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum = Math.max(arr[i], arr[i] + sum);
            if (sum > s) s = sum;
        }
        return s;
    }

    public static void SubarrayWithMaxSum(List <Integer> nums) {
        // Initialize currMax and globalMax
        // with first value of nums
        int currMax = nums.get(0), globalMax = nums.get(0);
        // Initialize endIndex startIndex,globalStartIndex
        int endIndex = 0;
        int startIndex = 0, globalMaxStartIndex = 0;

        // Iterate for all the elements of the array
        for (int i = 1; i < nums.size(); ++i) {

            // Update currMax and startIndex
            if (nums.get(i) > nums.get(i) + currMax) {
                currMax = nums.get(i);
                startIndex = i; // update the new startIndex
            }

            // Update currMax
            else if (nums.get(i) < nums.get(i) + currMax) {
                currMax = nums.get(i) + currMax;
            }

            // Update globalMax and globalMaxStartIndex
            if (currMax > globalMax) {
                globalMax = currMax;
                endIndex = i;
                globalMaxStartIndex = startIndex;
            }
        }

        System.out.println("Start -> " + globalMaxStartIndex + " End ->" + endIndex);
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[] {-1, -2, -3, -4}, 4));
        SubarrayWithMaxSum(Arrays.asList(-1, -2, -3, -4));
    }
}
