package easy.strings;

/**
 * User: garvit
 * Date: 19/12/19 9:19 AM
 */

/*
Implement strStr()
https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/
*/

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        if (haystack == null) {
            return -1;
        }
        int needleLen = needle.length();
        for (int i = 0; i <= haystack.length() - needleLen; i++) {
            if (haystack.substring(i, i + needleLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
