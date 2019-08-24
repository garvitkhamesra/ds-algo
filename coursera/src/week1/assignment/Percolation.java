/* *****************************************************************************
 *  Name:              Garvit Khamesra
 *  Coursera User ID:  -
 *  Last modified:     18/08/2019
 **************************************************************************** */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] grid;
    private int numberOfOpenSites;
    private int gridLength;
    private WeightedQuickUnionUF weightedQuickUnionUF;

    public Percolation(int n) {
        grid = new int[n+1][n+1];
        numberOfOpenSites = 0;
        gridLength = n+1;
        weightedQuickUnionUF = new WeightedQuickUnionUF(n*n + 2);
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++) {
                if (i == 1) {
                    int tempId = xyTo1D(i, j);
                    weightedQuickUnionUF.union(0, tempId);
                }
                else if (i == n) {
                    int tempId = xyTo1D(i, j);
                    weightedQuickUnionUF.union(tempId, gridLength);
                }
                grid[i][j] = -1;
            }
    }

    public void open(int row, int col) {
        exception(row, col);
        grid[row][col] = 1;
        int tempId = xyTo1D(row, col);
        System.out.println(weightedQuickUnionUF.connected(0, tempId)+ " -> first " + row + ", " + col + ", " + tempId);
        if (isOpen(row, col-1)) weightedQuickUnionUF.union(tempId, xyTo1D(row, col - 1));
        if (col < gridLength - 1)
            if (isOpen(row, col + 1)) weightedQuickUnionUF.union(tempId, xyTo1D(row, col + 1));
        if (isOpen(row -1, col)) weightedQuickUnionUF.union(tempId, xyTo1D(row -1, col));
        if (row < gridLength - 1)
            if (isOpen(row + 1, col)) weightedQuickUnionUF.union(tempId, xyTo1D(row + 1, col));
        numberOfOpenSites++;
        System.out.println(weightedQuickUnionUF.connected(0, tempId)+ " -> last " + row + ", " + col + ", " + tempId );
    }

    public boolean isOpen(int row, int col) {
        if (grid[row][col] == 1) return true;
        return false;
    }

    public boolean isFull(int row, int col) {
        exception(row, col);
        int tempId = xyTo1D(row, col);
        if (isOpen(row, col) && weightedQuickUnionUF.connected(tempId, 0)) return true;
        return false;
    }

    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    public boolean percolates() {
        if (weightedQuickUnionUF.connected(0, gridLength)) return true;
        return false;
    }

    private int xyTo1D(int row, int column) {
        return (((row-1) * (gridLength-1)) + column);
    }

    private void exception(int row, int col) {
        if (row < 1 || row > gridLength - 1 ||
                col < 1 || col > gridLength - 1) throw new IllegalArgumentException("Given arguments are not valid!");
    }
}