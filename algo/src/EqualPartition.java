public class EqualPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 0) {
            return SubSetSum.isSubsetSum(nums, n, sum/2);
        }
        return false;
    }
}
