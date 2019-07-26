/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */


import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    public static void main(String[] args) {

    }

    private double[] threshods;
    private int trials;
    private double avgThreshold;
    private double mean;
    private double deviation;

    // performa independant trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n or trials cannot be 0 or negative");
        }
        threshods = new double[trials];
        this.trials = trials;
        // todo randomly perform trials
        for(int i = 0; i < trials; i++) {
            Percolation trial = new Percolation(n);
            do {
                // get a random row and random col
                // open the site
                int randomRow = StdRandom.uniform(1, n);
                int randomCol = StdRandom.uniform(1, n);

                trial.open(randomRow, randomCol);
            } while (!trial.percolates());
            // when it percolates, get the mean
            threshods[i] = trial.numberOfOpenSites() / n * n;
        }
    }

    // sample mean(average value) of percolation threshold
    public double mean() {
        double total = 0.0;
        for (double threshold: threshods) {
            total += threshold;
        }
        return total / trials;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        double totalDev = 0;
        for (double threshhold: threshods) {
            totalDev += Math.pow(Math.abs(mean - threshhold), 2);
        }
        return Math.sqrt(totalDev / trials - 1); // get the sample variance
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - interval();
    }

    // high endpoint of 95% of confidence interval
    public double confidenceHi() {
        return mean + interval();
    }

    private double interval() {
        return (1.96 * deviation) / Math.sqrt(trials);
    }
}
