package week4;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dot on 25/4/20 10:23 AM
 * Package: week4
 */
class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>() {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
            {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        } else {
            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        /*
        *
        * ["LRUCache","put","put","put","put","get","get"]
[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
*/
        LRUCache cache = new LRUCache(2);
        cache.get(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        cache.get(1);
        cache.get(2);
    }
}