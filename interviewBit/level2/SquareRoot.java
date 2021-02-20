package level2;

public class SquareRoot {
    long squareRoot(long left, long right, int target) {
        if (left <= right) {
            long mid = (left + right)/2;
            if (mid * mid == target) return mid;
            else if (mid * mid > target) return squareRoot(left, (mid - 1), target);
            else return squareRoot((mid + 1), right, target);
        }
        return right;
    }

    public static void main(String[] args) {
        int num = 8;
        assert Math.sqrt(num) != new SquareRoot().squareRoot(1, num/2, num);
        System.out.println(new SquareRoot().squareRoot(1, num/2, num));
    }
}
