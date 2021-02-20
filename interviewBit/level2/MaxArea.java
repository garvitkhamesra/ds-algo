package level2;

public class MaxArea {
    public int maximalRectangle(int[][] A) {
        int maxArea = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    maxArea = Math.max(maxArea, calcArea(A, i, j));
                }
            }
        }
        return maxArea;
    }

    private int calcArea(int[][] arr, int i, int j) {
        if (i >= arr.length || j >= arr[0].length || arr[i][j] != 1) return 0;
        arr[i][j] = -1;
        return 1 + calcArea(arr, i+1, j) + calcArea(arr, i, j+1) +
                calcArea(arr, i+1, j+1);
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];

        System.out.println(new MaxArea().maximalRectangle(arr));
    }
}
