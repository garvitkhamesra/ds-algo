package week3;

import java.util.List;

/**
 * Created by dot on 22/4/20 6:57 PM
 * Package: week3
 */
public class LeftMostColumn {
    //https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < dimensions.get(0); i++) {
            int temp = binarySearch(binaryMatrix, i, 0, dimensions.get(1)-1);
            result = temp ==  dimensions.get(0) ? result : Math.min(result, temp);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int binarySearch(BinaryMatrix binaryMatrix, int x, int i, int j) {
        if (i <= j) {
            int mid = i + (j - i)/2;
            int temp = binaryMatrix.get(x, mid);

            if (temp == 0) {
                return binarySearch(binaryMatrix, x, mid + 1, j);
            } else {
                return binarySearch(binaryMatrix, x, i, mid - 1);
            }
        }
        return i;
    }

    public int leftMostColumnWithOneTopDown(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int result = -1, row = dimensions.get(0), col =  dimensions.get(1);
        int pX = 0, pY = col - 1;

        while (pX < row && pY >= 0) {
            int temp = binaryMatrix.get(pX, pY);
            if (temp == 1) {
                result = pY;
                pY--;
            } else {
                pX++;
            }
        }

        return result;
    }
}
