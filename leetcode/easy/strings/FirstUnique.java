package easy.strings;

import java.util.HashMap;

/**
 * User: garvit
 * Date: 19/12/19 9:16 AM
 */

/*
First Unique Character in a String
https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
*/

public class FirstUnique {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
