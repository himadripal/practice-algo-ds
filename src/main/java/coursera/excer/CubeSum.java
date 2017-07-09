package coursera.excer;

import java.util.Hashtable;

/**
 * Created by hpal(mehimu@gmail.com) on 2/8/2017.
 */
public class CubeSum implements Comparable<CubeSum> {
    long cubeSum;
    int i,j;


    public CubeSum(int a,int b){
        this.i=a;
        this.j=b;
        this.cubeSum = i*i*i + j*j*j;
    }
    @Override
    public int compareTo(CubeSum that) {
        if(this.cubeSum < that.cubeSum) return -1;
        if(this.cubeSum > that.cubeSum) return 1;
        String s = this.toString()+"="+that.toString();
        System.out.println(s);
        return 0;
    }
    public String toString() {
        return cubeSum + " = " + i + "^3" + " + " + j + "^3";
    }


    public static void main(String[] args){
        //System.out.println(4&3);
        int n = 100;//Integer.parseInt(args[0]);

        // initialize priority queue
        MinPriorityQueue<CubeSum> pq = new MinPriorityQueue<>(n+1);
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }
        Hashtable table = new Hashtable();
        // find smallest sum, print it out, and update
        while (pq.size()>0) {
            CubeSum s = pq.delMin();
           // System.out.println(s);
            if (s.j < n)
                pq.insert(new CubeSum(s.i, s.j + 1));
        }
    }
}
