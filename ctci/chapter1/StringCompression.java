package chapter1;

public class StringCompression {
    /*
        Question Explanation
            The question is to return a compressed string. eg abcd -> abcd, aabbccddeeaaaa -> a2b2c2d2e2a4
        Solution approaches
            1. Use of stringbuilder is key to avoid new string creations
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(N)
    */

    public static String getCompressedString(String str) {
        StringBuilder compressedStr = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if ((i+1) >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressedStr.append(str.charAt(i));
                compressedStr.append(count);
                count = 0;
            }
        }
        return str.length() >= compressedStr.length() ? compressedStr.toString() : str;
    }

    public static void main(String[] args) {
        System.out.println(getCompressedString("abcd"));
    }
}
