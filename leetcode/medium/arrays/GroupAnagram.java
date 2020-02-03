package arrays;

import java.util.*;

/**
 * Created by dot on 3/2/20 9:53 AM
 * Package: arrays
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;
        if (strs.length == 1) {
            res.add(Arrays.asList(strs[0]));
            return res;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            if (map.containsKey(temp)) {
                List<String> t = new ArrayList<>(map.get(temp));
                t.add(strs[i]);
                map.put(temp, t);
            } else {
                map.put(temp, Arrays.asList(strs[i]));
            }
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        GroupAnagram groupAnagram = new GroupAnagram();
        String[] strings = new String[3];
        strings[0] = "ate";
        strings[1] = "eat";
        strings[2] = "tea";
        groupAnagram.groupAnagrams(strings);
    }
}
