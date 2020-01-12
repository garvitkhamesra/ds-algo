package others;

/**
 * Created by dot on 12/1/20 12:11 PM
 * Package: others
 */
public class ProductAndSub {
    public int subtractProductAndSum(int n) {
        int sum = 0, pr = 1;
        while (n > 0) {
            int x = n % 10;
            sum += x;
            pr *= x;
            n = n/10;
        }

        return pr -sum;
    }
}
