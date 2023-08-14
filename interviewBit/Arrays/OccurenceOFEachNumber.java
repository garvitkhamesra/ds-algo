package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class OccurenceOFEachNumber {
    public ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a: A) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                int x = map.get(a);
                map.put(a, x + 1);
            }
        }

        return new ArrayList<>(map.values());
    }

}
