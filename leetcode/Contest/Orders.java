import java.util.*;

/**
 * Created by dot on 19/4/20 8:41 AM
 * Package: PACKAGE_NAME
 */
class Orders {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        if (orders == null || orders.size() == 0) return res;

        TreeMap<Integer, List<String>> map = new TreeMap<>();
        Set<String> dishes = new HashSet<>();
        for (List<String> list: orders) {
            String food = list.get(2);
            int table = Integer.parseInt(list.get(1));

            dishes.add(food);
            if (map.containsKey(table)) {
                List<String> strings = map.get(table);
                strings.add(food);
                map.put(table, strings);
            } else {
                map.put(table, new ArrayList<String>(){{add(food);}});
            }
        }

        List<String>foodItems = new ArrayList<>(dishes);
        Collections.sort(foodItems);

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> val = new ArrayList<>();
            val.add(String.valueOf(entry.getKey()));
            List<String> arr = entry.getValue();
            for (String s : foodItems) {
                val.add(String.valueOf(Collections.frequency(arr, s)));
            }
            res.add(val);
        }

        foodItems.add(0, "Table");
        res.add(0, foodItems);

        return res;
    }
}