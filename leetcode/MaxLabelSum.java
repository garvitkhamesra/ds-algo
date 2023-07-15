import java.util.*;

/**
 * User: garvit
 * Date: 25/02/21 12:04 PM
 */
public class MaxLabelSum {
    public static long getMaxSum(int[] values, int[] labels, int maxLabelCount) {
        if (maxLabelCount < 1) return 0;
        Map<Integer, List<Integer>> labelMap = new HashMap<>();
        for (int i = 0; i < labels.length; i++) {
            List<Integer> val;
            if (labelMap.containsKey(labels[i])) {
                val = labelMap.get(labels[i]);
            } else {
                val = new ArrayList<>();
            }
            val.add(values[i]);
            Collections.sort(val, Collections.reverseOrder());
            labelMap.put(labels[i], val);
        }

        long sum = 0;

        for (Map.Entry<Integer, List<Integer>> entry: labelMap.entrySet()) {
            List<Integer> val = entry.getValue();
            for (int i = 0; i < val.size() && i < maxLabelCount; i++) {
                sum += val.get(i);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getMaxSum(new int[] {1,2,3,4,8}, new int[] {5,6,5,7,5}, 2));
    }
}
