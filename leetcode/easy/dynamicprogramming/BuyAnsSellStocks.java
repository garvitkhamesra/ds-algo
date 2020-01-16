package dynamicprogramming;

/**
 * Created by dot on 16/1/20 8:21 AM
 * Package: dynamicprogramming
 */
public class BuyAnsSellStocks {
    // 1 day
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            if (prices[i] - min > ans) {
                ans = prices[i] - min;
            }
        }
        return ans;
    }
}
