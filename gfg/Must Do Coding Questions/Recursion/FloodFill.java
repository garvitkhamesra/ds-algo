package Recursion;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {   int c = image[sr][sc];
        changeColor(image, sr, sc, newColor, c);
        return image;
    }

    void changeColor(int[][] image, int sr, int sc, int newColor, int c) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || image[sr][sc] != c || image[sr][sc] == newColor)
            return;
        image[sr][sc] = newColor;
        changeColor(image, sr-1, sc, newColor, c);
        changeColor(image, sr+1, sc, newColor, c);
        changeColor(image, sr, sc-1, newColor, c);
        changeColor(image, sr, sc+1, newColor, c);
    }
}
