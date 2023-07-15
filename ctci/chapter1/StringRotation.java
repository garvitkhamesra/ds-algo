package chapter1;

public class StringRotation {
    /*
        Question Explanation
            The question is to check if the given string is a rotation of the other string
        Solution approaches
            1. We can add the same string 2twice and then check if it is a substring
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(1)
    */

    public static boolean isStringRotation(String first, String second) {
        if (first.length() != second.length() || first.length() > 0) {
            String temp = first + first;
            if (temp.contains(second)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(StringRotation.isStringRotation("sbottlewater", "waerbottle"));
    }
}
