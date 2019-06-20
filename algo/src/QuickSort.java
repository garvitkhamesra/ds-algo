public class QuickSort {

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i+1;
    }

    private static int partitionDiffApproach(int[] arr, int l, int r) {
        int pivot = arr[(l+r)/2];
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
        return l;
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // Anyone can be used for doing partition
            //int p = partitionDiffApproach(arr, l, r);
            int p = partition(arr, l, r);
            quickSort(arr, l, p-1);
            quickSort(arr, p+1, r);
        }
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
