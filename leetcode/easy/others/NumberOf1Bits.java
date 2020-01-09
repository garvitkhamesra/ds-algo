package others;

/**
 * Created by dot on 9/1/20 9:43 AM
 * Package: others
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) res++;
            mask <<= 1;
        }
        return res;
    }
}

    /*public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }*/