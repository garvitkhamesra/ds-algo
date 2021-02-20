package challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

/**
 * User: garvit
 * Date: 16/02/21 11:18 AM
 */
class LRUCache {
    public LinkedHashMap<Integer, Integer> map;
    public int capacity;

    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<Integer, Integer>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if(this.map.containsKey(key)) {
            int val = this.map.get(key);
            this.map.remove(key);
            this.put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int val) {
        if(this.map.containsKey(key)) {
            this.map.remove(key);
        } else if(this.map.size() == this.capacity) {
            int firstKey = this.map.entrySet().iterator().next().getKey();
            this.map.remove(firstKey);
        }
        this.map.put(key, val);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int capacity = Integer.parseInt(br.readLine());
        int testCases = Integer.parseInt(br.readLine());

        LRUCache lruCache = new LRUCache(capacity);

        while (testCases > 0) {
            String input = br.readLine();
            String[] op = input.split(" ");
            if (op.length < 2) throw new NumberFormatException("Wrong input");

            switch (op[0]) {
                case "GET":
                    System.out.println(lruCache.get(Integer.parseInt(op[1])));
                    break;
                case "PUT":
                    if (op.length < 3) throw new NumberFormatException("Wrong input");
                    lruCache.put(Integer.parseInt(op[1]), Integer.parseInt(op[2]));
                    System.out.println(lruCache);
                    break;
                default:
                    System.out.println("Wrong Operation");
                    break;
            }
            testCases--;
        }
    }
}
