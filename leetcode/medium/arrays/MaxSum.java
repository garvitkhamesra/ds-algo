package arrays;

public class MaxSum {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int[] maxSum = array.clone();
        maxSum[1] = array[0] > array[1] ? array[0] : array[1];

        for (int i = 2; i < array.length; i++) {
            maxSum[i] = Math.max(maxSum[i-1], maxSum[i-2] + array[i]);
        }
        return maxSum[array.length - 1];
    }

    public static int maxSubsetSumNoAdjacentOptSpace(int[] array) {
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int first = array[0] > array[1] ? array[0] : array[1];
        int current = first, second = array[0];

        for (int i = 2; i < array.length; i++) {
            current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }
        return current;
    }
}
