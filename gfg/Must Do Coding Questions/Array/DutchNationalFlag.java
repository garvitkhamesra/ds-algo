package Array;

import java.util.Arrays;
import java.util.Random;

public class DutchNationalFlag {
    public void sort(int arr[], int l, int m, int r) {
        while(m <= r) {
            switch (arr[m]) {
                case 0:
                    swap(arr, l, m);
                    l++; m++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    swap(arr, m, r);
                    r--;
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    private void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void printArray(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Random rd = new Random();
        int[] arr = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(3);
        }
        int size = arr.length;

        DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();
        dutchNationalFlag.sort(arr, 0, 0, size-1);
        dutchNationalFlag.printArray(arr);
    }
}
