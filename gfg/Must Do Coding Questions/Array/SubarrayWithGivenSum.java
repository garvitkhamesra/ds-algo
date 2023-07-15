package Array;

import java.util.ArrayList;

public class SubarrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> res = new ArrayList<>();
        int j = 0, sum = arr[0];
        for (int i = 1; i <= n; i++) {
            while (sum > s && j < i-1) {
                sum -= arr[j];
                j++;
            }
            if (sum == s) {
                res.add(j+1);
                res.add(i);
                return res;
            }
            if (i < n) sum += arr[i];
        }
        res.add(-1);
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5,
                103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        System.out.println(subarraySum(arr, 42, 468));
    }
}
