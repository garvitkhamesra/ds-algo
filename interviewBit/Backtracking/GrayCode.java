package Backtracking;

import java.util.*;

public class GrayCode {

    public static ArrayList<Integer> grayCode(int A) {
        char[] str = new char[A];
        Arrays.fill(str, '0');
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        grayCodeSolver(str, result);
        return new ArrayList<>(result);
    }

    private static void grayCodeSolver(char[] str, LinkedHashSet<Integer> result) {
        if (result.contains(Integer.parseInt(String.valueOf(str), 2))) return;

        result.add(Integer.parseInt(String.valueOf(str), 2));

        for (int i = str.length - 1; i >= 0; i--) {
            flip(str, i);
            grayCodeSolver(str, result);
            flip(str, i);
        }
    }

    private static void flip(char[] str, int i) {
        str[i] = str[i] == '0' ? '1' : '0';
    }

    public static ArrayList<Integer> grayCode1(int A) {
        ArrayList<String> res = grayCodeSolver1(A);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            result.add(Integer.parseInt(res.get(i), 2));
        }
        return result;
    }

    private static ArrayList<String> grayCodeSolver1(int n) {
        if (n == 1) {
            ArrayList<String> result = new ArrayList<>();
            result.add("0");
            result.add("1");
            return result;
        }

        ArrayList<String> prevResult = grayCodeSolver1(n-1);
        ArrayList<String> newResult = new ArrayList<>();

        for (int i = 0; i < prevResult.size(); i++) {
            newResult.add("0" + prevResult.get(i));
        }

        for (int i = 0; i < prevResult.size(); i++) {
            newResult.add("1" + prevResult.get(i));
        }

        return newResult;
    }


    public static void main(String[] args) {
//        System.out.println(grayCode(1));
//        System.out.println(grayCode(2));
//        System.out.println(grayCode(3));
//        System.out.println(grayCode(4));
        System.out.println(grayCode(15));

    }


}
