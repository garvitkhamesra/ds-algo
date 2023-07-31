package String;

import java.util.ArrayList;

public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> A) {
        int min = Integer.MAX_VALUE, ind = 0;
        for (int i = 0; i < A.size(); i++) {
            if (min > A.get(i).length()) {
                min = A.get(i).length();
                ind = i;
            }
        }

        String s = A.get(ind);
        String res = s;
        for (int i = 0; i < A.size(); i++) {
            String pre = "";
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == A.get(i).charAt(j)) {
                    pre += s.charAt(j);
                } else break;
            }
            res = pre.length() < res.length() ? pre : res;
        }

        return res;
    }
}
