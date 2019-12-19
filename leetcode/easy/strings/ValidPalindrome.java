package easy.strings;

/**
 * User: garvit
 * Date: 19/12/19 9:17 AM
 */

/*
Valid Palindrome
https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
*/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        s = s.toLowerCase();
        while (l < r) {
            if (s.charAt(l) == ' ' || !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if (s.charAt(r) == ' ' || !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }
            if (s.charAt(l) != s.charAt(r)) {

                return false;
            }
            l++;r--;
        }

        return true;
    }
}
