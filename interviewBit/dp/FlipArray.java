package dp;

import java.util.Arrays;
import java.util.List;

public class FlipArray {

    class Pair {
        int sum;
        int flips;

        public Pair(int sum, int flips) {
            this.sum = sum;
            this.flips = flips;
        }

        private Pair compare(Pair pair) {
            if(this.sum > pair.sum) return this;
            if(this.sum < pair.sum) return pair;
            int minFlips = Math.min(this.flips, pair.flips);
            return new Pair(this.sum, minFlips);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "sum=" + sum +
                    ", flips=" + flips +
                    '}';
        }
    }

    private Pair dfs(List<Integer> A, int n, int capacity, Pair[][] dp) {
        if(n == 0 || capacity == 0) {
            return new Pair(0, 0); // sum, minFlips
        }

        // memoization condition
        if(dp[n][capacity].sum != -1) {
            return dp[n][capacity];
        }

        Pair temp1 = dfs(A, n-1, capacity, dp); // leave

        if(capacity - A.get(n-1) >= 0) {

            Pair a2 = dfs(A, n-1, capacity - A.get(n-1), dp); // pick
            Pair temp2 = new Pair(A.get(n-1) + a2.sum, 1 + a2.flips);
//            Pair temp2 = new Pair(capacity - A.get(n-1), 1 + a2.flips);

            dp[n][capacity] = temp1.compare(temp2);

        } else {
            dp[n][capacity] = temp1;
        }

        return dp[n][capacity];
    }


    public int solve(final List<Integer> A) {

        int n = A.size();
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += A.get(i);
        }
        int capacity = sum/2;

        Pair[][] dp = new Pair[n+1][capacity+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = new Pair(-1, -1);
            }
        }

        Pair ans = dfs(A, n, capacity, dp);
//        System.out.println(ans);

        return ans.flips;
    }

    public static void main(String[] args) {
        FlipArray flipArray = new FlipArray();
        System.out.println(flipArray.solve(Arrays.asList( 8, 4, 5, 7, 6, 2 )));
    }
}
