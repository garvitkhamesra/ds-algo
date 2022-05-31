package chapter8;

public class RecursiveMultiply {

    private static int minProduct(int a, int b) {
        int small = a > b ? b : a;
        int big = b > a ? b : a;
        return minProductHelper(small, big);
    }

    private static int minProductHelper(int small, int big) {
        if (small == 0) return 0;
        else if (small == 1) return big;

        int s = small >> 1;
        int halfProduct = minProductHelper(s, big);

        if (small % 2 == 0) {
            return halfProduct + halfProduct;
        } else {
            return halfProduct + halfProduct + big;
        }
    }

    public static void main(String[] args) {
        System.out.println(minProduct(9, 5));
    }
}
