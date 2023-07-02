package Array;

import java.util.Arrays;

public class InversionCount {

    static long inversionCount(long arr[], long N) {
        return mergeSort(arr, 0, arr.length-1);
    }

    static long mergeSort(long arr[], int l, int r) {
        long count = 0;

        if (l < r) {
            int m = (l+r)/2;
            count += mergeSort(arr, l, m);
            count += mergeSort(arr, m+1, r);

            count += merger(arr, l, m, r);
        }

        return count;
    }

    static long merger(long arr[], int l, int m, int r) {
        long count = 0;
        long[] a = Arrays.copyOfRange(arr, l, m + 1);
        long[] b = Arrays.copyOfRange(arr, m + 1, r+1);

        int i = 0, j = 0, k = l;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                arr[k++] = a[i++];
            } else {
                arr[k++] = b[j++];
                count += (m+1) - (l+i);
            }
        }

        while (i < a.length)
            arr[k++] = a[i++];
        while (j < b.length)
            arr[k++] = b[j++];

        return count;
    }

}
