package week3;

/**
 * Created by dot on 19/4/20 4:48 PM
 * Package: week3
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        return binarySearch(nums, 0, nums.length-1, target);
    }

    private int binarySearch(int[] nums, int i, int length, int target) {
        if (i <= length) {
            int mid = i + (length - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[i] <= nums[mid]) {
                if (nums[mid] > target && target >= nums[i]) {
                    return binarySearch(nums, i, mid - 1, target);
                }
                return binarySearch(nums, mid + 1, length, target);
            } else {
                if (nums[mid] < target && target <= nums[length]) {
                    return binarySearch(nums, mid + 1, length, target);
                }
                return binarySearch(nums, i, mid - 1, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        System.out.println(search.search(new int[] {5,1,3},3));
    }
}
