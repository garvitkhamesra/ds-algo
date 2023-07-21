package dp;

import java.util.Arrays;

public class RectangleAreaWithPermutations {
    public int solve(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i != 0 && A[i][j] != 0) A[i][j] = A[i][j] + A[i-1][j];
            }
        }

        for (int i = 0; i < A.length; i++) {
            Arrays.sort(A[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                max = Math.max(max, A[i][j] *(A[0].length - j));
            }
        }
        return max;
    }

}
