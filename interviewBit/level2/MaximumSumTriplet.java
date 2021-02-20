package level2;

import java.util.TreeSet;

public class MaximumSumTriplet {
    public int solveBruteForce(int[] A) {
        int res = Integer.MIN_VALUE, s = Integer.MIN_VALUE, t = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 2; i++) {
            int f = A[i];
            for (int j = i+1; j < A.length - 1; j++) {
                if (f < A[j]) {
                    s = A[j];
                    for (int k = j+1; k < A.length; k++) {
                        if (s < A[k]) {
                            t = A[k];
                            res = Math.max(res, (f+s+t));
                        }
                    }
                }
            }
        }
        return res;
    }

    public int solveOpt(int[] A) {
        int max[] = new int[A.length];
        max[A.length - 1] = A[A.length - 1];

        for (int i = A.length - 2; i >= 0; i--) {
            max[i] = Math.max(A[i], max[i+1]);
        }

        int res = Integer.MIN_VALUE, t = Integer.MIN_VALUE;
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(Integer.MAX_VALUE);
        for (int i = 0; i < A.length - 1; i++) {
            if (max[i+1] > A[i] && treeSet.lower(A[i]) != null)
                res = Math.max(res, (treeSet.lower(A[i]) + max[i+1] + A[i]));
            treeSet.add(A[i]);
        }

        if (res == Integer.MIN_VALUE) return -1;
        return res;
    }

    /*
        Note:
        1. TreeSet can be leveraged for max of min from left side
        2. For right side we can maintain the max array
            2.1 Trick to do this in o(n) is to start from end so that only max things will we in the array
                with the correct order we need.
    */
}
