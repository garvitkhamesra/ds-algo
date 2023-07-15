import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval {

    public int longestWPI(int[] hours) {
        int res = 0, score = 0, n = hours.length;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1;
            } else {
                /*
                * What we are maintaining is the first occurrence of the neg score and if agin it occurs then we check
                * the index of score -1 because of strict nature when it occurs for the first time to get the in btn length*/
                seen.putIfAbsent(score, i);
                if (seen.containsKey(score - 1))
                    res = Math.max(res, i - seen.get(score - 1));
            }
        }
        return res;
    }
    public int longestWPIBF(int[] hours) {
        int m = 0, res = 0;

        for (int i = 0; i < hours.length; i++) {
            int td = 0, nd = 0;
            for (int j = i; j < hours.length; j++) {
                if (hours[j] > 8) td++;
                else nd++;
                if (td > nd) {
                    res = Math.max(res, j-i+1);
                }
            }
        }
        return res;
    }
}


