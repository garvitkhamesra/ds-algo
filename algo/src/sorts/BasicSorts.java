package sorts;

import java.util.Arrays;

public class BasicSorts {

    public void insertionSort(int arr[], int size) {
        // Sorting all the element before it
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public void bubbleSort(int arr[], int size) {
        // Bubbling out the largest element at last
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public void printArray(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[] = new int[] {6, 5, 5, 4, 7, 3, 58, 2, 1};
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
