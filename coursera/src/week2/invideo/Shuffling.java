import java.util.Arrays;
import java.util.Random;

public class Shuffling<T> {
    public void shuffle(Comparable<T> arr[], int size) {
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int r = random.nextInt(size);
            swap(arr, i, r);
        }
    }

    private void swap(Comparable<T> arr[], int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void printArray(Comparable<T> arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Random rd = new Random();
        Integer[] arr = new Integer[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(1000);
        }
        int size = arr.length;

        Shuffling shuffling = new Shuffling();
        shuffling.shuffle(arr, size);
        shuffling.printArray(arr);
    }
}
