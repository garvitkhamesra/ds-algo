package Arrays;

public class SortArrayWithSquares {
    public int[] solve(int[] a) {
        int i = 0, k= a.length-1, j = a.length-1;
        int[] A = new int[j+1];
        while (i <= j) {
            if (a[i] * a[i] > a[j] * a[j]) {
                A[k--] = a[i] * a[i];
                i++;
            } else {
                A[k--] = a[j] * a[j];
                j--;
            }
        }

        return A;
    }
}
