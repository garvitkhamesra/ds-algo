package week1.assignment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double trailsNumber;
    private final double [] means;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        exception(n, trials);
        means = new double[trials];
        trailsNumber = trials;
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int numberOfOpenSites = 0;
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n+1);
                int col = StdRandom.uniform(1, n+1);
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                    numberOfOpenSites++;
                }
            }
            means[i] = (double) numberOfOpenSites / (n*n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(means);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(means);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - getCalc();
    }

    private double getCalc() {
        return (1.96 * stddev())/Math.sqrt(trailsNumber);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + getCalc();
    }

    public static void main(String[] args) {
        // test client (optional)
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, t);

        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }

    private void exception(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("Given arguments are not valid!");
    }
}
