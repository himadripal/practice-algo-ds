package coursera.excer;

/**
 * Created by hpal(mehimu@gmail.com) on 2/7/2017.
 */
public class MinPriorityQueue<Item extends Comparable<Item>> {
    private int count;
    private Item[] items = null;
    public MinPriorityQueue(int capacity){
        items = (Item[]) new Comparable[capacity+1];
        count=0;
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
    public Item delMin(){
        Item item = items[1];
        swap(1,count--);
        sink(1);
        items[count+1] = null;
        return item;
    }
    private boolean greater(int i, int j){
        return items[i].compareTo(items[j])>0;
    }
    private void swap(int i, int j){
        Item item = items[i];
        items[i] = items[j];
        items[j] = item;
    }
    private void swim(int k){
        while(k>1 && greater(k/2,k)){
            swap(k/2,k);
            k=k/2;
        }
    }
    private void sink(int k){
        while(2*k <= count){
            int j = 2*k;
            if(j < count && greater(j,j+1)) j++;
            if(greater(j,k)) break;
            swap(k,j);
            k = j;
        }
    }

    public static void main(String[] args){
        MinPriorityQueue<Integer> minPQ = new MinPriorityQueue<>(10);

        minPQ.insert(5);
        minPQ.insert(4);
        minPQ.insert(3);
        minPQ.insert(2);
        minPQ.insert(1);
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());


    }
}
