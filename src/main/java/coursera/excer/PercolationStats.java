package coursera.excer;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;  

/* *
 * Created by Himadri Pal on 12/14/2016.
 */
public class PercolationStats {

    private double[] results  =  null;  
    public PercolationStats(int n,  int trials) {
        if (n <=  0) throw new IllegalArgumentException("n should be >0");
        if (trials <=  0) throw new IllegalArgumentException("trials should be >0");
        results  =  new double[trials];
        for (int k = 0;   k < trials;   k++) {
            Percolation p  =  new Percolation(n);
            int i;
            int j;
            while (!p.percolates()) {
                // generate random i and j
                i = StdRandom.uniform(1,n+1);
                j = StdRandom.uniform(1,n+1);
                if(p.isOpen(i,j)) continue;
                p.open(i,  j);
            }
            // System.out.println("numOfOpen"+(p.numberOfOpenSites()));
            double percolationThresold  =  (double)p.numberOfOpenSites()/(n*n);
            // store the results in the double[] for  mean stddev and 95% confi low and hi
            results[k] = percolationThresold;
        }
    }
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("please provide n and trials");  
        }
        PercolationStats pStats  =  new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        System.out.println("mean                                             =  "+  String.format("%.9f",  pStats.mean()));
        System.out.println("stddev                                           =  "+  String.format("%.9f",  pStats.stddev()));
        System.out.println("95% confidence interval                          =  "
                +  String.format("%.9f",  pStats.confidenceLo())+", "+String.format("%.9f",pStats.confidenceHi()));

    }

    /* *
     * Call StdStats.mean()
     * @return mean in double
     */
    public double mean() {
        return StdStats.mean(results);  
    }

    /* *
     * Call StdStats.stddev()
     * @return standard deviation
     */
    public double stddev() {

        return StdStats.stddev(results);  
    }

    /* *
     * Calculate confidenceLow based on mean and stddev and trails

     * @return 95% confidence low value
     */
    public double confidenceLo() {
        double mean  =  mean();  
        double stddev  =  stddev();  
        return mean - (1.96*stddev)/Math.sqrt(results.length);

    }

    /* *
     * Calculate confidenceHi based on mean and stddev and trails

     * @return 95% confidence hi
     */
    public double confidenceHi() {
        double mean  =  mean();  
        double stddev  =  stddev();  
        return mean + (1.96*stddev)/Math.sqrt(results.length);

    }
}
