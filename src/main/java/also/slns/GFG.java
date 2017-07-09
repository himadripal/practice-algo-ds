package also.slns;
import java.util.*;
import java.lang.*;

public class GFG {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        PriorityQueue<Integer> maxQueue = new PriorityQueue(n/2,Collections.reverseOrder());

        PriorityQueue<Integer> minQueue = new PriorityQueue(n/2);
        int median=0;
        for(int i=0; i< n; i++){
            int number = in.nextInt();
            int size = maxQueue.size()-minQueue.size();
            switch(size){
                case 0 : {
                    if(number < median){
                        maxQueue.add(number);
                        median=maxQueue.peek();
                    }else{
                        minQueue.add(number);
                        median = minQueue.peek();
                    }
                    break;
                }
                case 1: {
                    if(number < median){
                        minQueue.add(maxQueue.poll());
                        maxQueue.add(number);
                    }else{
                        minQueue.add(number);
                    }
                    median = (maxQueue.peek()+minQueue.peek())/2 ;
                    break;
                }
                case -1 : {
                    if (number < median){
                        maxQueue.add(number);
                    }else{
                        maxQueue.add(minQueue.poll());
                        minQueue.add(number);
                    }
                    median = (maxQueue.peek()+minQueue.peek())/2 ;
                    break;
                }
            }
            System.out.println(median);
        }


    }
}