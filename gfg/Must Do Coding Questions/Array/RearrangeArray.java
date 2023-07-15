package Array;

public class RearrangeArray {
    public static void rearrange(long arr[], int n){

        // Your code here
        long mx = arr[n-1] + 1;
        int mini = 0, maxi = n-1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[maxi--] % mx )* mx;
            } else {
                arr[i] += (arr[mini++] % mx) * mx;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] /= mx;
        }
    }

    public static void main(String[] args) {
        rearrange(new long[] {1,2,3,4,5,6}, 6);
    }
}
