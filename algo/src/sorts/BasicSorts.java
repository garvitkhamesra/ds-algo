package sorts;

import java.util.Arrays;

public class BasicSorts {

        public void insertionSort(Comparable arr[], int size) {
        // Sorting all the element before it
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j-1].compareTo(arr[j]) > 0) {
                    Comparable temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public void bubbleSort(Comparable arr[], int size) {
        // Bubbling out the largest element at last
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    Comparable temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public void printArray(Comparable arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[] {6, 34, 5, 4, 1, 3, 58, 2, 1};
        int size = arr.length;
        BasicSorts basicSorts = new BasicSorts();

        // Bubble Sort
        basicSorts.bubbleSort(arr, size);
        basicSorts.printArray(arr);

        // Insertion Sort
        basicSorts.insertionSort(arr, size);
        basicSorts.printArray(arr);
    }
}
