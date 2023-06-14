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

    public static int searchInRotatedArray(int[] nums, int target) {
        int s = 0, e = nums.length-1;
        while (s <= e) {
            int mid = (s+e)/2;
            if (target == nums[mid]) return mid;
            if (nums[s] <= nums[mid]) { //checking if first half array is sorted if so
                if (nums[s] <= target && target < nums[mid]) { //check if target lies in the range if so
                    e = mid - 1;                              // search in first half only
                } else {                                         //else search in second half
                    s = mid + 1;
                }
            } else {  //if first half isn't sorted go and check for second
                if(nums[mid] < target && target <= nums[e]){ //check if target lies in second half
                    s = mid + 1;                             //if so search in second half
                } else{
                    e = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        System.out.println(search.search(new int[] {5,1,3},3));
        System.out.println(searchInRotatedArray(new int[] {4,5,6,7,0,1,2},6));
    }
}
