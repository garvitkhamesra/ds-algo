/**
 * Created by dot on 25/6/20 11:05 PM
 * Package: PACKAGE_NAME
 */
public class SingleNumber {
    public static int singleNonDuplicate(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }

    static int binarySearch(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + (r - l)/2;
            if (mid == 0 && nums[mid+1] == nums[mid]) return  nums[mid];
            else if (mid == nums.length - 1 && nums[mid-1] == nums[mid]) return  nums[mid];
            else if (nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]) return mid;
            else if (mid % 2 != 0 && nums[mid - 1] == nums[mid]) return binarySearch(nums, mid + 1, r);
            else return binarySearch(nums, l, mid -1);

        }

        return nums[l];
    }

    static int test(int[] arr) {
        int maxSumTillNow = 0, currentSum = 0;
        for (int arrIterator = 0; arrIterator < arr.length; arrIterator++) {
            currentSum = Math.max(0, currentSum + arr[arrIterator]);
            maxSumTillNow = Math.max(currentSum, maxSumTillNow);
        }
        return maxSumTillNow;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {1,1,2,3,3,4,4,8,8};
        int[] nums = new int[] {1,2,-3,4,5,-6};
        test(nums);
//        int[] nums = new int[] {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(nums));
    }
}
