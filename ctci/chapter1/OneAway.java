package chapter1;

public class OneAway {
    /*
        Question Explanation
            The question is to check if the given strings are 1 operation away from each other.
            operations: add, delete, replace
        Solution approaches
            1. Use of stringbuilder is key to avoid new string creations
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(N)
    */

    public static boolean isOneAway(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) return false;

        String temp1, temp2;
        if (str1.length() > str2.length()) {
            temp1 = str1;
            temp2 = str2;
        } else {
            temp1 = str2;
            temp2 = str1;
        }
        int i = 0, j = 0, count = 0;
        while (j < temp2.length() && i < temp1.length()) {
            if (temp1.charAt(i) != temp2.charAt(j)) {
                count++;
                if (temp1.length() == temp2.length()) j++;
            } else {
                j++;
            }
            i++;
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        System.out.println(OneAway.isOneAway("pale", "ple"));
        System.out.println(OneAway.isOneAway("pales", "pale"));
        System.out.println(OneAway.isOneAway("pale", "bale"));
        System.out.println(OneAway.isOneAway("pale", "bae"));
    }
}
