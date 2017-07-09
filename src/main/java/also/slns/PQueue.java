package also.slns;

import java.util.Comparator;

/**
 * Created by Himadri Pal (mehimu@gmail.com) on 6/19/2017.
 */
public class PQueue<Item> {
    Item[] items = null;
    int count;
    Comparator<Item> comparator;

    public PQueue(int capacity, Comparator<Item> comparator){
        items = (Item[]) new Comparable[capacity+1];
        count=0;
        this.comparator=comparator;
    }

    public void insert(Item item){
        items[++count]=item;
        swim(count);
    }

    private void swim(int k){
        while(k > 1 && less(k/2,k) ){
            swap(k/2,k);
            k=k/2;
        }
    }
    public Item poll(){
        Item item = items[1];
        swap(1,count--);
        sink(1);
        return item;
    }
    public void sink(int k){
        while(2*k <= count){
            int i=2*k;
            if(i < count && less(i,i+1)) i++;
            if(less(k,i)) swap(k,i);
            k=i;
        }
    }
    public Item peek(){
        return items[1];
    }
    private boolean less(int i, int j){
        Item item1=items[i], item2=items[j];
        return comparator.compare(item1,item2) < 0;
    }
    private void swap(int i,int j){
        Item temp = items[i];
        items[i]=items[j];
        items[j]=temp;
    }

    public static void main(String[] args){
        //change the comparator to make it MaxQueue
        PQueue<String> pQueue = new PQueue<>(10, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                //reverse the order here to make it maxPQueue
                return t1.compareTo(s);
            }
        });
        pQueue.insert("A");
        pQueue.insert("B");
        pQueue.insert("C");

        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.peek());


    }
}
