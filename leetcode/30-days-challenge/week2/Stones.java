package week2;

import java.util.Arrays;

/**
 * Created by dot on 12/4/20 4:12 PM
 * Package: PACKAGE_NAME
 */
public class Stones {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        for (int i = 0; i < stones.length; i++) {
            Arrays.sort(stones);
            int len = stones.length - 1;
            if (stones[len] <= 0 || stones[len - 1] <= 0) break;
            if (stones[len] == stones[len -1]) {
                stones[len] = -1 * stones[len];
                stones[len - 1] = -1 * stones[len - 1];
            } else {
                stones[len] = stones[len] - stones[len - 1];
                stones[len - 1] = -1 * stones[len - 1];
            }
        }

        Arrays.sort(stones);
        return stones[stones.length - 1] < 0 ? 0 : stones[stones.length - 1];
    }
}
