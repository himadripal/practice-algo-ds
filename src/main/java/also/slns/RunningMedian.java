package also.slns;

import coursera.excer.MaxPriorityQueue;
import coursera.excer.MinPriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by 371865 on 2/7/2017.
 */
public class RunningMedian {


    public static void main(String[] args){
        PriorityQueue queue = new PriorityQueue();

            Double median = 0.0;
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            MaxPriorityQueue<Double> maxPQ = new MaxPriorityQueue<>(n/2+1);
            MinPriorityQueue<Double> minPQ = new MinPriorityQueue<>(n/2+1);
            int[] a = new int[n];

            for(int a_i=0; a_i < n; a_i++){
                Double number = in.nextInt()*1.0;
                int cases = maxPQ.size() - minPQ.size();
                switch (cases){
                    case 0 : {
                        if(number < median){
                            maxPQ.insert(number);
                            median = maxPQ.peek();
                        }else {
                            minPQ.insert(number);
                            median = minPQ.peek();
                        }
                        break;
                    }
                    case 1:{
                        if(number < median){
                            minPQ.insert(maxPQ.delMax());
                            maxPQ.insert(number);
                        }else{
                            minPQ.insert(number);
                        }
                        median = (maxPQ.peek()+minPQ.peek())/2;
                        break;
                    }
                    case -1:{
                        if(number < median){
                            maxPQ.insert(number);
                        }else {
                            maxPQ.insert(minPQ.delMin());
                            minPQ.insert(number);
                        }
                        median = (maxPQ.peek()+minPQ.peek())/2;
                        break;
                    }
                }
                System.out.println(String.format("%.1f",median));
            }
        }

}
