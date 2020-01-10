package math;

import java.util.HashMap;

/**
 * Created by dot on 10/1/20 9:53 PM
 * Package: math
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char ch[] = s.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n-1; i++) {
            if (map.get(ch[i]) >= map.get(ch[i+1])) {
                ans += map.get(ch[i]);
            } else {
                ans += map.get(ch[i+1]) - map.get(ch[i]);
                i++;
            }
        }
        if (n>=2) {
            if (map.get(ch[n-2]) >= map.get(ch[n-1])) {
                ans+=map.get(ch[n-1]);
            }} else {
            ans +=map.get(ch[0]);
        }
        return ans;
    }
}
