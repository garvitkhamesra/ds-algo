package chapter1;

import java.util.Arrays;

public class IsPermutation {

    /*
        Question Explanation
            The question is to find out the given strings are permutation of each other or not.
        Solution approaches
            1. Sort the strings and compare them char by char
                1.1 Time Complexity : O(NLogN)
                1.2 Space Complexity : O(1)
            2. By using extra array of size 128(Ascii character count)
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(1)
    */

    public static boolean isPermutationBySort(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return new String(sChar).equals(new String(tChar));
    }

    public static boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) return false;
        int chars[] = new int[128];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i)]--;
            if (chars[t.charAt(i)] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(IsPermutation.isPermutation("absdfdbbc", "cbbsdfba"));
        System.out.println(IsPermutation.isPermutationBySort("abbsdfbc", "csdfdbbba"));
    }
}
