package easy.strings;

/**
 * User: garvit
 * Date: 19/12/19 9:17 AM
 */

/*
Valid Anagram
https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/
*/

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        int[] charsMap = new int['z'-'a'+1];

        for(char c: s.toCharArray()) {
            int pos = c - 'a';
            charsMap[pos]++;
        }

        for(char c: t.toCharArray()) {
            int pos = c - 'a';
            charsMap[pos]--;
        }

        for(int count: charsMap) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }
}
