package week1.assignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/* *****************************************************************************
 *  Name:              Garvit Khamesra
 *  Coursera User ID:  -
 *  Last modified:     18/08/2019
 **************************************************************************** */
public class Percolation {

    private boolean[] grid;
    private int numberOfOpenSites;
    private final WeightedQuickUnionUF weightedQuickUnionUF;
    private final int number;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("Given arguments are not valid!");
        number = n;
        grid = new boolean[n*n + 2];
        numberOfOpenSites = 0;
        weightedQuickUnionUF = new WeightedQuickUnionUF(n*n + 2);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        exception(row, col);
        int index = xyTo1D(row, col);
        if (grid[index]) return;
        numberOfOpenSites++;
        grid[index] = true;
        if (row == 1) {
            weightedQuickUnionUF.union(0, index);
        }
        if (row == number) {
            weightedQuickUnionUF.union(number*number + 1, index);
        }
        if (col > 1 && isOpen(row, col-1))
            weightedQuickUnionUF.union(index, xyTo1D(row, col-1));

        if (col < number && isOpen(row, col+1))
            weightedQuickUnionUF.union(index, xyTo1D(row, col+1));

        if (row < number && isOpen(row+1, col))
            weightedQuickUnionUF.union(index, xyTo1D(row+1, col));

        if (row > 1 && isOpen(row-1, col))
            weightedQuickUnionUF.union(index, xyTo1D(row-1, col));
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        exception(row, col);
        return grid[(xyTo1D(row, col))];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        exception(row, col);
        return weightedQuickUnionUF.find(0) == weightedQuickUnionUF.find(xyTo1D(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return weightedQuickUnionUF.find(0) == weightedQuickUnionUF.find(number*number + 1);
    }

    private void exception(int row, int col) {
        if (row < 1 || row > number || col < 1 || col > number) throw new IllegalArgumentException("Given arguments are not valid!");
    }

    private int xyTo1D(int row, int column) {
        return (((row-1) * (number)) + column);
    }

    // test client (optional)
    public static void main(String[] args) {
        // test client (optional)
    }
}