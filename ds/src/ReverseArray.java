import java.util.Arrays;

public class ReverseArray {
    public static void reverseIterativeMethod(int[] arr) {
        int l = 0, r = arr.length-1;
        while (l <= r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void reverseRecursiveMethod(int[] arr, int l, int r) {
        if (l > r) return;
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        reverseRecursiveMethod(arr, ++l, --r);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int l = 0, r = arr.length-1;
        reverseIterativeMethod(arr);
        System.out.println(Arrays.toString(arr));
        reverseRecursiveMethod(arr, l, r);
        System.out.println(Arrays.toString(arr));
    }
}
