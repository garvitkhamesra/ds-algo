import java.util.*;

/**
 * Created by dot on 19/4/20 8:41 AM
 * Package: PACKAGE_NAME
 */
class Orders {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        if (orders == null || orders.size() == 0) return res;

        Map<String, List<String>> map = new HashMap<>();
        SortedSet<String> dishes = new TreeSet<>();
        for (List<String> list: orders) {
            String food = list.get(2);
            String table = list.get(1);

            dishes.add(food);
            if (map.containsKey(table)) {
                List<String> strings = map.get(table);
                strings.add(food);
                map.put(table, strings);
            } else {
                map.put(table, new ArrayList<String>(){{add(food);}});
            }
        }

        return res;
    }
}