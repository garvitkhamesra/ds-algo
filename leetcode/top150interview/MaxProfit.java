package top150interview;

/**
 * Created by dot on 12/1/20 12:10 PM
 * Package: arrays
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxprofit = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) min = prices[i];
            if (maxprofit < prices[i] - min)
                maxprofit = prices[i] - min;
        }
        return maxprofit;
    }

    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
