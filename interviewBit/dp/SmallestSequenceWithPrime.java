package dp;

import java.util.*;

public class SmallestSequenceWithPrime {

    public static int[] firstDNumbersWithPrimes(int A, int B, int C, int D) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(1);

        Set<Integer> seen = new HashSet<>();
        seen.add(1);

        int[] result = new int[D];
        int index = 0;

        while (index < D) {
            int curr = heap.poll();
            if (curr != 1) {
                result[index++] = curr;
            }

            for (int num : new int[]{curr * A, curr * B, curr * C}) {
                if (!seen.contains(num)) {
                    seen.add(num);
                    heap.add(num);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int A = 19;
        int B = 31;
        int C = 31;
        int D = 9;

        int[] result = firstDNumbersWithPrimes(A, B, C, D);
        System.out.println(Arrays.toString(result));
    }
}
