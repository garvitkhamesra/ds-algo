package week3.invideo;

import edu.princeton.cs.algs4.Insertion;

import java.util.Arrays;

/**
 * Created by dot on 18/4/20 6:23 PM
 * Package: week3.assignment.invideo
 */
public class MergeSort {
    private static final int CUTOFF = 7;

    private void merge(Comparable[] a, Comparable[] b, int low, int mid, int max) {
        for (int k = low; k <= max; k++) {
            b[k] = a[k];
        }
        int i = low, j = mid+1;
        for (int k = low; k <= max; k++) {
            if (i > mid) {
                a[k] = b[j++];
            } else if (j > max) {
                a[k] = b[i++];
            } else if (b[i].compareTo(b[j]) > 0) {
                a[k] = b[j++];
            } else {
                a[k] = b[i++];
            }
        }
    }

    private void sort(Comparable[] a, Comparable[] b, int low, int max) {
        if (max <= low + CUTOFF - 1) {
            Insertion.sort(a, low, max);
            return;
        }
        int mid = low + (max - low) / 2;

        sort(a, b, low, mid);
        sort(a, b, mid + 1, max);

        if (a[mid].compareTo(a[mid+1]) < 0) return;
        merge(a, b, low, mid, max);
    }

    public void sortBottomUp(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        for (int i = 1; i < a.length; i = i + i) {
            for (int j = 0; j < a.length - i; j += i + i) {
                merge(a, b, j, j+i-1, Math.min(a.length - 1, j+i+i-1));
            }
        }
    }

    public void sort(Comparable[] a, int low, int high) {
        Comparable[] b = new Comparable[a.length];
        sort(a, b, low, high);
    }

    public static void main(String[] args) {
        Comparable[] arr = new Comparable[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i - 1;
        }
        System.out.println("Before the merge sort array value is -> "
                + Arrays.toString(arr));
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length);

        mergeSort.sortBottomUp(arr);
        System.out.println("After the merge sort array value is -> "
                + Arrays.toString(arr));
    }
}
