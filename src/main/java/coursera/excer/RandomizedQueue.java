package coursera.excer;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by hpal(mehimu@gmail.com) on 1/8/2017.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items = null;
    private int itemCount;


    public RandomizedQueue(){
        items = (Item[]) new Object[1];
    }
    public boolean isEmpty(){
        return itemCount==0;
    }
    public int size(){
        return itemCount;
    }
    public void enqueue(Item item){
        if(item == null) throw new NullPointerException("Item is null");
        if(isEmpty()) {
            if(items.length==0){
                items = (Item[])new Object[1];
            }
            items[itemCount++] = item;
            return;
        }
        if(items.length==itemCount) resize(items.length*2);
        int idx = StdRandom.uniform(itemCount);
        Item temp = items[idx];
        items[idx] = item;
        items[itemCount++]=temp;
    }
    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException("No more elements");
        Item item = items[--itemCount];
        items[itemCount] = null;
        if(items.length/4==itemCount) resize(items.length/2);
        return item;
    }

    public Item sample(){
        if(isEmpty()) throw new NoSuchElementException("No more elements");
        return items[StdRandom.uniform(itemCount)];
    }

    private void resize(int length){
        Item[] resizedItems = (Item[]) new Object[length];
        for(int i=0; i < itemCount;i++){
            resizedItems[i]=items[i];
        }
        items = resizedItems;
    }

    public static void main(String[] args){
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        /*randomizedQueue.enqueue("A");
        randomizedQueue.enqueue("B");
        randomizedQueue.enqueue("C");
        randomizedQueue.enqueue("D");
        for(String s : randomizedQueue){
            System.out.println(s);
        }*/
        randomizedQueue.enqueue(23);
        System.out.println( randomizedQueue.dequeue() );
        randomizedQueue.enqueue(46);
        System.out.println( randomizedQueue.dequeue() );

        System.out.println(  randomizedQueue.isEmpty()) ;   // ==> false
        //randomizedQueue.enqueue(31);
        //randomizedQueue.enqueue(38);
        randomizedQueue.enqueue(12);
        System.out.println( randomizedQueue.isEmpty())  ;//   ==> false
        //System.out.println( randomizedQueue.dequeue())  ;//   ==> 38
        randomizedQueue.enqueue(1);
      //System.out.println( randomizedQueue.dequeue()) ;//    ==> null
        System.out.println( randomizedQueue.sample()) ;//    ==> null
        System.out.println( randomizedQueue.dequeue() );

        System.out.println( randomizedQueue.sample()) ;//    ==> null


      long t1=System.currentTimeMillis();
       for(int i=0; i< 1000; i++){
           randomizedQueue.enqueue(i);
       }
        System.out.println();
        for(Integer i : randomizedQueue){
            System.out.println(i);

        }

        for(int i=0; i < 10;i++){
           System.out.println(randomizedQueue.dequeue());
       }
       System.out.println("time = "+String.valueOf(System.currentTimeMillis()-t1));


    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item>{
        private int iteration =0;
        public ArrayIterator(){
            /*reshuffledArr = (Item[]) new Object[itemCount];
            for(int i=0,j=0;i<items.length;i++){
                if(items[i]==null) continue;
                int index = StdRandom.uniform(itemCount);
                while(reshuffledArr[index]!=null && j < reshuffledArr.length){
                    index = StdRandom.uniform(itemCount);
                }
                reshuffledArr[index] = items[i];
                j++;
            }*/
        }
        @Override
        public boolean hasNext() {
            return iteration < itemCount;
        }
        @Override
        public Item next() {
            return items[iteration++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not supported");
        }
    }
}
