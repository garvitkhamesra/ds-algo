public class KaratsubaMultiplication {
    /*
    Fast Multiplication
    * */

    public static long karatsubaMultiplication(long x, long y) {
        int noOneLength = numLength(x);
        int noTwoLength = numLength(y);

        int maxNumLength = Math.max(noOneLength, noTwoLength);

        int smallValue = 1 << 4;
        if (maxNumLength < smallValue)
            return x * y;

        // Rounding up the
        // divided Max length
        maxNumLength
                = (maxNumLength / 2) + (maxNumLength % 2);

        // Multiplier
        long maxNumLengthTen
                = (long)Math.pow(10, maxNumLength);

        // Compute the expressions
        long b = x / maxNumLengthTen;
        long a = x - (b * maxNumLengthTen);
        long d = y / maxNumLengthTen;
        long c = y - (d * maxNumLength);

        // Compute all mutilpying variables
        // needed to get the multiplication
        long z0 = karatsubaMultiplication(a, c);
        long z1 = karatsubaMultiplication(a + b, c + d);
        long z2 = karatsubaMultiplication(b, d);

        return z0 + ((z1 - z0 - z2) * maxNumLengthTen)
                + (z2 * (long)(Math.pow(10, 2 * maxNumLength)));
    }

    public static int numLength(long n) {
        int noLen = 0;
        while (n > 0) {
            noLen++;
            n /= 10;
        }
        return noLen;
    }

    public static void main(String[] args) {
        long product1 = karatsubaMultiplication(1345, 63456);
        System.out.println("Product : " + product1);
    }
}
