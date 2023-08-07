package String;

import java.util.Arrays;
import java.util.Collections;

public class ReverseString {
    public String solve(String A) {
        A = A.trim();
        String[] a = A.split(" ");
        Collections.reverse(Arrays.asList(a));
        StringBuilder s = new StringBuilder();
        for (String ss: a) {
            if (!ss.isEmpty()) {
                s.append(ss);
                s.append(" ");}
        }
        return s.toString().trim();
    }
}
