package week1.assignment;

import week1.assignment.Percolation;

public class PercolationStats {

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        exception(n, trials);
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return 1D;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return 1D;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return 1D;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return 1D;
    }

    public static void main(String[] args) {

    }

    private void exception(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("Given arguments are not valid!");
    }
}
