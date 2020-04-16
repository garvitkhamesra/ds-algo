package week2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dot on 14/4/20 12:59 PM
 * Package: PACKAGE_NAME
 */
public class StringShifts {
    public String stringShift(String s, int[][] shift) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,0);

        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                map.put(0, map.get(0) + shift[i][1]);
            } else {
                map.put(1, map.get(1) + shift[i][1]);
            }
        }

        map.put(0, map.get(0) % s.length());
        map.put(1, map.get(1) % s.length());

        int l = map.get(0);
        int r = map.get(1);

        if (l > r) {
            return rotateString(s, (l-r));
        } else if (l < r) {
            return rotateString(s, (s.length()-(r-l)));
        } else {
            return s;
        }
    }

    public static String rotateString(String s, int amount) {
        StringBuilder a = new StringBuilder(s.substring(0, amount));
        a = a.reverse();

        StringBuilder b = new StringBuilder(s.substring(amount));
        b = b.reverse();

        a.append(b);

        return a.reverse().toString();
    }
}
