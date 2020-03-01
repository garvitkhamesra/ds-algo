import java.util.ArrayList;
import java.util.List;

/**
 * Created by dot on 12/2/20 6:44 PM
 * Package: PACKAGE_NAME
 */

public class SubArraySum {
    public class Indices {
        int i;
        int j;

        public Indices(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Indices{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    private List<Indices> getMaxSubArray(int[] arr, int k) {
        List<Indices> res = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            int sum = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    Indices indices = new Indices(i, j);
                    res.add(indices);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,-1,0,4,-2,1,-3,0,5,-2,2};
        SubArraySum subArraySum = new SubArraySum();
        List<Indices> maxSubArray = subArraySum.getMaxSubArray(arr, 0);
        System.out.println(maxSubArray);
    }
}