import java.util.Arrays;
import java.util.List;

public class maxSteps {
    public static long journey(List<Integer> path, int maxStep) {
        if (path == null || path.size() == 0) return 0;
        long ans = path.get(0);
        int i = 0, index = 0;
        long temp = 0;
        for (i = 0; i < path.size(); i++) {
            for (int j = i+1; j < path.size() && j <= maxStep; j++) {
                long val = path.get(j) + ans;
                if (temp < val) {
                    temp = path.get(j) + ans;
                    i = j;
                }
            }
            ans += temp;
        }
        return ans-path.get(0);
    }

    public static void main(String[] args) {
        System.out.println(journey(Arrays.asList(new Integer[] {10, -20, -5}), 3));
    }
}
