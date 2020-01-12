package math;

/**
 * Created by dot on 12/1/20 12:09 PM
 * Package: math
 */
public class PowerOf3 {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}

// log 10 / log n % 1 == 0