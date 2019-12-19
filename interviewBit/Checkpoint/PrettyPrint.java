package Checkpoint;

import java.util.ArrayList;

/**
 * User: garvit
 * Date: 27/09/19 10:46 AM
 */
public class PrettyPrint {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int tempA = A;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int k = A; k > tempA; k--) {
                list.add(k);
            }
            for (int j = 0; j < 2*tempA -2; j++) {
                list.add(tempA);
            }
            for (int l = tempA; l <= A; l++) {
                list.add(l);
            }
            result.add(list);
            tempA--;
        }

        tempA = A -1;
        for (int i = 0; i < A-1; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int k = A; k > tempA; k--) {
                list.add(k);
            }
            for (int j = 0; j < 2*tempA -2; j++) {
                list.add(tempA);
            }
            for (int l = tempA; l <= A; l++) {
                list.add(l);
            }
            result.add(list);
            tempA++;
        }
        return result;
    }
}

/*
    Print concentric rectangular pattern in a 2d matrix.
    Let us show you some examples to clarify what we mean.

    Example 1:

    Input: A = 4.
    Output:

    4 4 4 4 4 4 4
    4 3 3 3 3 3 4
    4 3 2 2 2 3 4
    4 3 2 1 2 3 4
    4 3 2 2 2 3 4
    4 3 3 3 3 3 4
    4 4 4 4 4 4 4
*/
