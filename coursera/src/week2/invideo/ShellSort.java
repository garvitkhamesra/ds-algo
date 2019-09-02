import java.sql.Time;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class ShellSort {
    public void shellSort(Comparable arr[], int size, int h, int x) {
        while (h >= 1) {
            for (int i = 0; i <= size - h; i++) {
                for (int j = i; j < size-h && (arr[j].compareTo(arr[j+h]) > 0); j += h)
                    swap(arr, j, j+h);

            }
            h = 3*(--x) + 1;
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
        Random rd = new Random();
        Integer[] arr = new Integer[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(200);
        }
        int size = arr.length;

        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(arr, size, 7, 2);
        shellSort.printArray(arr);
    }
}
