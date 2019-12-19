package easy.strings;

/**
 * User: garvit
 * Date: 19/12/19 9:14 AM
 */

/*
Reverse String
https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
*/

public class ReverseString {
    public void reverseString(char[] s) {
        int l = 0, r = s.length-1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
