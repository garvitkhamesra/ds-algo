package Arrays;

import java.util.ArrayList;

public class MinMax {

    public int solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int a: A) {
            if (min > a) {
                min = a;
            }

            if (max < a) {
                max = a;
            }
        }
        return min + max;
    }

}
