package sorts;

import java.util.Arrays;
import java.util.Random;

public class BasicSorts<T> {

    public void insertionSort(Comparable arr[], int size) {
        // Sorting all the element before it
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j-1].compareTo(arr[j]) > 0) {
                    swap(arr, j, j-1);
                }
            }
        }
    }

    public void bubbleSort(Comparable arr[], int size) {
        // Bubbling out the largest element at last
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public void selectionSort(Comparable arr[], int size) {
        // Finding minimum and then swap to current index
        for (int i = 0; i < size-1; i++) {
            int min = i;
            for (int j = i; j < size; j++) if (arr[j].compareTo(arr[min]) < 0) min = j;
            swap(arr, min, i);
        }
    }

    private void swap(Comparable arr[], int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void printArray(Comparable arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        BasicSorts basicSorts = new BasicSorts();

        Random rd = new Random();
        Integer[] arr = new Integer[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        int size = arr.length;

        // Bubble Sort
        basicSorts.bubbleSort(arr, size);
        basicSorts.printArray(arr);

        // Insertion Sort
        basicSorts.insertionSort(arr, size);
        basicSorts.printArray(arr);

        // Selection Sort
        basicSorts.selectionSort(arr, size);
        basicSorts.printArray(arr);

    }
}
