package level2;

public class StepsInInfiniteGrid {
    public int coverPoints(int[] A, int[] B) {
        int ans = 0;

        for (int i = 0; i < A.length - 1; i++) {
            ans += getDistance(A[i], B[i], A[i+1], B[i+1]);
        }

        return ans;
    }

    public int getDistance(int x1, int y1, int x2, int y2) {
        return Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
    }

    /*
    * Things to remember: The distance in a grid between 2 points is the max of abs of relative dist
    * */
}
