package chapter1;

public class IsUnique {

    /*
        Question Explanation
            The question is to find out the given string is unique or not, without using extra space.
        Solution approaches
            1. If extra space constrain is not there then use hasset
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(N)
            2. By using extra array of size 128(Ascii character count)
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(1) because its a constant size.
            3. If additional array is also no allowed
                1. Use of bit vector
                    1.1 Time Complexity : O(N)
                    1.2 Space Complexity : O(N)
                2. Brute force by checking each character by character
                    1.1 Time Complexity : O(N^2)
                    1.2 Space Complexity : O(1)
                3. Sort the string and compare next
                    1.1 Time Complexity : O(NlogN)
                    1.2 Space Complexity : O(1)
    */

    public static boolean isUnique(String string) {
        boolean chars[] = new boolean[128];
        for (int i = 0; i < string.length(); i++) {
            int val = string.charAt(i);
            if (chars[val]) {
                return false;
            }
            chars[val] = true;
        }
        return true;
    }

    // Need to more questions for better understanding
    public static boolean isUniqueUsingBitVector(String string) {
        // Assumption that the string have only lower case characters
        int checker = 0;
        for (int i = 0; i < string.length(); i++) {
            int bitAtIndex = string.charAt(i) - 'a'; // gives us an index for each character by making a as 0
            if ((checker & (1 << bitAtIndex)) > 0) // making the index as 1 and checking with checker if already present or not
                return false;
            checker = checker | (1 << bitAtIndex); // check variable gets updated with 1 at the given index
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(IsUnique.isUnique("sttrirng"));
        System.out.println(IsUnique.isUniqueUsingBitVector("sttrirng"));
    }
}
