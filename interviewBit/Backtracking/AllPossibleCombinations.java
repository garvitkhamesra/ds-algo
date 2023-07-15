package Backtracking;

import java.util.ArrayList;

public class AllPossibleCombinations {
    public static ArrayList<String> specialStrings(ArrayList<String> A) {
        return specialStrings(A, new ArrayList<String>(), "", 0);
    }

    private static  ArrayList<String> specialStrings(ArrayList<String> arr, ArrayList<String> out, String res, int ind) {
        if (res.length() >= arr.size()) {
            out.add(res);
            return out;
        }

        String temp = arr.get(ind);

        for (int i = 0; i < temp.length(); i++) {
            res += temp.charAt(i);
            specialStrings(arr, out, res, ind + 1);
            res = res.substring(0, res.length() - 1);
        }

        return out;
    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("aa");
        arr.add("bb");
        ArrayList<String> strings = specialStrings(arr);
        System.out.println(strings);
    }

}
