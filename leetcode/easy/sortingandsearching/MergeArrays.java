package sortingandsearching;

/**
 * Created by dot on 10/1/20 9:54 AM
 * Package: sortingandsearching
 */
public class MergeArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int i = m - 1, j = n - 1, k = nums1.length - 1;

        while (i >= 0 && j >=0 && k >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        if (j >= 0) {
            for (int l = j; l >=0; l--) {
                nums1[k--] = nums2[l];
            }
        }
    }
}
