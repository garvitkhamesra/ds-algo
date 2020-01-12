package arrays;

/**
 * Created by dot on 12/1/20 12:10 PM
 * Package: arrays
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
