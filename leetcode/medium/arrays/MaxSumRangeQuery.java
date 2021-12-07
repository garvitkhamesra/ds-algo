package medium.arrays;

import java.util.Arrays;

public class MaxSumRangeQuery {
    public static int maxSumRangeQuery(int[] nums, int[][] requests) {
        long res = 0, mod = (long)1e9 + 7;
        int n = nums.length, count[] = new int[n];
        for (int[] r: requests) {
            count[r[0]] += 1;
            if (r[1] + 1 < n)
                count[r[1] + 1] -= 1;
        }
        for (int i = 1; i < n; ++i)
            count[i] += count[i - 1];
        Arrays.sort(nums);
        Arrays.sort(count);
        for (int i = 0; i < n; ++i)
            res += (long)nums[i] * count[i];
        return (int)(res % mod);
    }

    public static void main(String[] args) {
        int req[][] = new int[2][2];
        req[0] = new int[] {1,2};
        req[1] = new int[] {2,4};
        System.out.println(maxSumRangeQuery(new int[] {1,2,4,5,6}, req));
    }
}
