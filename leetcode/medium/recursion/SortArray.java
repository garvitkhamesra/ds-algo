package medium.recursion;

import java.util.Arrays;

public class SortArray {
    public static void sort(int[] arr, int n) {
        System.out.println("Sort " + Arrays.toString(arr)+" Arr Size: " + n);
        if (n == 0) return;
        int val = arr[n];
        sort(arr, n-1);
        insert(arr, val, n);
    }

    private static void insert(int[] arr, int value, int n) {
        System.out.println("Insert " + Arrays.toString(arr)+" Arr Size: " + n);
        if (n == 0 || arr[n-1] <= value) {
            System.out.println("Inserting Value: " + value + " at " + n);
            arr[n] = value;
        } else {
            int val = arr[n-1];
            insert(arr, value, n - 1);
            arr[n] = val;
            System.out.println("Inserting Value: " + val + " at " + n);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, 4, 2, 9, 1};

        for (int i : arr) {
            System.out.print(i + " ,");
        }
        System.out.println("\n>>>");
        sort(arr, arr.length - 1);
        System.out.println("<<<");
        for (int i : arr) {
            System.out.print(i + " ,");
        }
    }
}
