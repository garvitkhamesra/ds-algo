/**
 * Created by dot on 1/7/20 10:45 PM
 * https://leetcode.com/problems/arranging-coins/
 */

public class ArrangeCoins {
    public int arrangeCoinsApproach1(int n) {
        // O(n)
        if (n == 0) return 0;
        int count = 0, i = 1;
        while (n - i >= 0) {
            n = n - i;
            i++;
            count++;
        }
        return count;
    }

    public int arrangeCoinsApproach2(int n) {
        // O(logn)
        long l = 0, r = n;
        long m;
        while (l <= r) {
            m = l + (r - l) / 2;
            long curr = (m * (m + 1)) / 2;

            if (n == curr) return (int) m;

            if (n < curr) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int) r;
    }

    public int arrangeCoinsApproach3(int n) {
        // O(1)
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }
}
