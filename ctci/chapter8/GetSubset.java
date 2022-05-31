package chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class GetSubset {

    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
        return getSubsetsHelper(set, 0);
    }

    private static ArrayList<ArrayList<Integer>> getSubsetsHelper(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> result;
        if (set.size() == index) {
            result = new ArrayList<>();
            result.add(new ArrayList<>());
        } else {
            result = getSubsetsHelper(set, index+1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : result) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            result.addAll(moreSubsets);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(Arrays.deepToString(getSubsets(set).toArray()));
    }
}
