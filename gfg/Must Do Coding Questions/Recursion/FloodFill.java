package Recursion;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        helper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    void helper(int[][] arr, int i, int j, int c, int p) {
        if (i < 0 || j < 0 || i >= arr.length|| j >= arr[0].length) return;
        if (arr[i][j] != p) return;
        if (arr[i][j] == c) return;
        arr[i][j] = c;
        helper(arr, i+1, j, c, p);
        helper(arr, i-1, j, c, p);
        helper(arr, i, j+1, c, p);
        helper(arr, i, j-1, c, p);
    }
}
