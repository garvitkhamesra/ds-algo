package top150interview;

public class MergeArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int e1 = m-1, e2 = n-1;

        for (int p = m+n-1; p >=0; p--) {
            if (e2 < 0) break;
            if (e1 >= 0 && nums1[e1] > nums2[e2]) {
                nums1[p] = nums1[e1--];
            } else {
                nums1[p] = nums2[e2--];
            }
        }

    }
}
