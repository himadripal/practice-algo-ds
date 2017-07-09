package coursera.excer;

/**
 * Created by hpal(mehimu@gmail.com) on 2/7/2017.
 */
public class MaxPriorityQueue<Item extends Comparable<Item>> {

    private int count;
    private Item[] items = null;

    public MaxPriorityQueue(int capacity){
        // +1 as the Indexing starts with 1 - 0th index is empty for less code
        items = (Item[]) new Comparable[capacity+1];
        count = 0;
    }
    public int size(){
        return count;
    }
    public void insert(Item item){
        items[++count] = item;
        swim(count);
    }
    public Item peek(){
        return items[1];
    }
    public Item delMax(){
        Item item = items[1];
        //swap it with top element
        swap(1,count);
        //remove the highest from heap by reducing heap size by 1
        --count;
        //sink element at top to its right place.
        sink(1);
        // remove the ref of removed item
        items[count+1] = null;
        return item;
    }
    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }
    private void swap(int i,int j){
        Item item = items[i];
        items[i] = items[j];
        items[j] = item;
    }
    private void sink(int k){
        while(2*k <= count){
            int i=2*k;
            if(i < count && less(i,i+1)) i++;
            if(less(i,k)) break;
            swap(k,i);
            k = i;
        }
    }
    private void swim(int k){
        while(k > 1 && less(k/2,k)){
            swap(k,k/2);
            k=k/2;
        }
    }

public static void main(String[] args){
    MaxPriorityQueue<Integer> maxPQ = new MaxPriorityQueue<>(10);
    maxPQ.insert(1);
    maxPQ.insert(2);
    maxPQ.insert(3);
    maxPQ.insert(4);
    System.out.println(maxPQ.delMax());
    System.out.println(maxPQ.delMax());
    System.out.println(maxPQ.delMax());
    System.out.println(maxPQ.delMax());

}

}
