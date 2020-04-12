/**
 * Created by dot on 12/4/20 9:52 AM
 * Package: PACKAGE_NAME
 */
public class N3Grid {
    public int numOfWays(int n) {
        long a = 6;
        long b = 6;

        long temp;

        for (int i = 2; i <= n; i++) {
            temp = a;
            a = (2 * a + 2 * b) % 1000000007;
            b = (2 * temp + 3 * b) % 1000000007;
        }

        return (int) ((a + b) % 1000000007);
    }
}
