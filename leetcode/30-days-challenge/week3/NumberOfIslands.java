package week3;

/**
 * Created by dot on 17/4/20 10:53 PM
 * Package: week3
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) return 0;

        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands += iteration(grid, i, j);
                }
            }
        }

        return numberOfIslands;
    }

    private static int iteration(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';

        iteration(grid, i-1, j);
        iteration(grid, i+1, j);
        iteration(grid, i, j-1);
        iteration(grid, i, j+1);

        return 1;
    }
}
