import java.util.ArrayList;
import java.util.List;

/**
 * Created by dot on 18/4/20 9:15 PM
 * Package: week3.invideo
 */
public class FibonacciSum {
    private static List fibonacci(int n) {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);

        int val = 0;
        int i = 2;

        while (val < n) {
            val = arr.get(i-1) + arr.get(i-2);
            arr.add(val);
            i++;
        }

        return arr;
    }

    public int findMinFibonacciNumbers(int k) {
        List<Integer> arr = fibonacci(k);
        int numberOfTerms = 0, j = arr.size() - 1;

        while(k > 0) {
            numberOfTerms += (k / arr.get(j));
            k %= (arr.get(j));
            j--;
        }
        return numberOfTerms;
    }
}
