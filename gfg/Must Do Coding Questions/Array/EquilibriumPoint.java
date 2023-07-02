package Array;

public class EquilibriumPoint {
    public static int equilibriumPoint(long arr[], int n) {

        int lsum = 0, rsum = 0;
        for (int i = 0; i < n; i++) {
            lsum += arr[i];
        }

        for (int i = n-1; i >= 0; i--) {
            lsum -= arr[i];

            if (lsum == rsum) return i+1;

            rsum += arr[i];
        }
        return -1;
    }
}
