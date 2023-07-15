public class ReverseInteger {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x%10;
            x = x/10;
        }
        result = result < 0 && result < Integer.MIN_VALUE ? 0 : result;
        result = result > 0 && result > Integer.MAX_VALUE ? 0 : result;
        return (int) result;
    }
}
