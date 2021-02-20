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
}
