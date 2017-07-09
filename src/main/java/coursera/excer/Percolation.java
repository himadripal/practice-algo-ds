package coursera.excer;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by hpal(mehimu@gmail.com) on 1/2/2017.
 */
public class Percolation {
    private WeightedQuickUnionUF wquuf= null;
    private WeightedQuickUnionUF backWashTracker= null;

    private int[] siteState = null;
    private int n = 0;
    private int noofOpenSites=0;

    public Percolation(int n){

        if(n <=0) throw new IllegalArgumentException("n must be greater than 0");
        wquuf = new WeightedQuickUnionUF(n*n +2);
        backWashTracker = new WeightedQuickUnionUF(n*n + 1);
        siteState = new int[n*n+2];
        this.n = n;
        for(int i=1; i < n*n+1 ; i++){
            siteState[i]=0;
        }
        siteState[0]=1;
        siteState[n*n+1]=1;
    }

    private int calculateIndex(int row, int col){
        return (row-1)*n +col;
    }
    public boolean isFull(int row, int col){
        checkArgument(row, col);
        int val = calculateIndex(row,col);
        return wquuf.connected(0,val) && backWashTracker.connected(0,val);
    }
    public boolean isOpen(int row, int col){
        checkArgument(row, col);
        return siteState[calculateIndex(row,col)] == 0 ? false : true;
    }
    public void open(int row, int col){
     checkArgument(row, col);
     int val = calculateIndex(row,col);
        if(!isOpen(row,col)) noofOpenSites++;
        siteState[val] = 1;

        // top row - coonect to virtual site at index 0;
        if(val <= n){
          wquuf.union(0,val);
          backWashTracker.union(0,val);
        //  return;
        }
        //bottom row - connect to virtual site at index n*n+1
        if(val >= (n * (n-1)+1)){
            wquuf.union(n*n+1,val);
           // return;
        }
        //connect the top neighbour if open
        if(row != 1 && isOpen(row-1,col)){
            int topVal = calculateIndex(row - 1, col);
            wquuf.union(val, topVal);
            backWashTracker.union(val, topVal);
        }
        //connect neighbour at bottom
        if(row != n && isOpen(row+1,col)){
            int bottomVal = calculateIndex(row + 1, col);
            wquuf.union(val, bottomVal);
            backWashTracker.union(val, bottomVal);
        }
        //connect the left neighbour
        if(col != 1 && isOpen(row,col-1)){
            int leftVal = calculateIndex(row, col - 1);
            wquuf.union(val, leftVal);
            backWashTracker.union(val, leftVal);
        }
        //connect the right neighbour
        if(col != n && isOpen(row,col+1)){
            int rightVal=calculateIndex(row,col+1);
            wquuf.union(val,rightVal);
            backWashTracker.union(val,rightVal);
        }
    }

    private void checkArgument(int row, int col) {
        if(row < 1 || row > n){
            throw new IndexOutOfBoundsException("row must be between 1 and N");

        }
        if(col < 1 || col > n){
            throw new IndexOutOfBoundsException("col must be between 1 and N");

        }
    }

    public int numberOfOpenSites(){
        return noofOpenSites;
    }
    public boolean percolates(){
        return wquuf.connected(0,n*n+1);
    }
}
