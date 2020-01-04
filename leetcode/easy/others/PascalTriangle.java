package easy.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: garvit
 * Date: 04/01/20 3:11 PM
 */

/*
Pascal triangle
https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/601/
*/

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) return new ArrayList<List<Integer>>();
        result.add(Arrays.asList(1));
        if (numRows == 1) return result;
        result.add(Arrays.asList(1, 1));
        if (numRows == 2) return result;

        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = result.get(i-1);
            List<Integer> subResult = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    subResult.add(temp.get(j));
                } else if (j != i) {
                    subResult.add(temp.get(j-1) + temp.get(j));
                } else {
                    subResult.add(temp.get(j-1));
                }
            }
            result.add(subResult);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.generate(4));
    }
}
