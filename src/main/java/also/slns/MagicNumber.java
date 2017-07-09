package also.slns;

import java.util.PriorityQueue;

/**
 * Created by 371865 on 3/22/2017.
 */
public class MagicNumber implements Comparable<MagicNumber> {
    int i;
    int number;
    public MagicNumber(int i,int multiply){
        this.i=i;
        this.number=number*i;
    }

    @Override
    public int compareTo(MagicNumber magicNumber) {
        if(magicNumber.number < this.number) return -1;
        else if(magicNumber.number > this.number) return 1;
        else return 0;
    }

    public static void main(String[] args){
        PriorityQueue<MagicNumber> queue = new PriorityQueue<>();
        for(int i=0; i< 10 ; i++){
            queue.add(new MagicNumber(i,3));
            queue.add(new MagicNumber(i,5));
            queue.add(new MagicNumber(i,7));
        }
    }
}
