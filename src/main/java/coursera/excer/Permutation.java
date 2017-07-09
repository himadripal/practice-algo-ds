package coursera.excer;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by hpal(mehimu@gmail.com) on 1/8/2017.
 */
public class Permutation {
    public Permutation(){

    }
    public static void main(String[] args){
        int k =0;
        if(args.length < 1){
            throw  new IllegalArgumentException("K must be specified");
        }else{
            k = Integer.valueOf(args[0]);
        }

        RandomizedQueue<String> queue = new RandomizedQueue<>();

        while(!StdIn.isEmpty()){
           // StdIn.isEmpty()
           String  s = StdIn.readString();
           queue.enqueue(s);
        }
        for(String item : queue){
             if(k--==0){
                 break;
             }
            System.out.println(item);

        }
    }
}
