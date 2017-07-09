package coursera.excer;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by hpal(mehimu@gmail.com) on 1/8/2017.
 */
public class Deque2<Item> implements Iterable<Item>{


    private Item[] items = null;
    private int itemCount;
    private int headIndex;
    private int tailIndex;
    private int headCount;
    private int tailCount;
    private int loopOverHead;
    private int loopOverTail;

    public Deque2(){
        items =(Item[]) new Object[1];
        headIndex =0;
        tailIndex =0;
        itemCount=0;
        loopOverHead=0;
        loopOverTail=items.length-1;
    }
    public boolean isEmpty(){
        //if no of elements =0 then true
        return itemCount==0;
    }
    public int size(){
        // no of elements
        return itemCount;
    }

    public void addFirst(Item item){
        if(item==null){
            throw new NullPointerException("Item is null");
        }
        if(isEmpty()){
            if(items.length==0) {
                items = (Item[]) new Object[1];
            }
            items[items.length-++headIndex] = item;
            headCount++;
            itemCount++;
            return;
        }
        if(itemCount==items.length) {
            resize(items.length*2);
        }
        items[items.length-++headIndex] = item;
        headCount++;
        itemCount++;
    }

    public void addLast(Item item){
        if(item==null){
            throw new NullPointerException("Item is null");
        }
        if(isEmpty()){
            if(items.length==0){
                items = (Item[])new Object[1];
            }
            items[tailIndex++] = item;
            tailCount++;
            itemCount++;
            return;
        }
        if(itemCount==items.length) {
            resize(items.length*2);
        }
        items[tailIndex++] = item;
        tailCount++;
        itemCount++;
    }

    public Item removeFirst(){
        if(isEmpty()) throw new NoSuchElementException("No element in queue");
        Item item;
        int idx = items.length - headIndex;
        if(headCount == 0){
            idx=loopOverHead++;
            tailCount--;
        }else{
            headIndex--;
            headCount--;
           // loopOverTail--;
        }
        item = items[idx];
        items[idx]=null;
        itemCount--;
        if(itemCount==items.length/4){
            resize(items.length/2);
        }
        return item;
    }
    public Item removeLast(){
        if(isEmpty()) throw new NoSuchElementException("No element in queue");
        Item item;
        int idx = tailIndex-1;
        if(tailCount == 0){
            idx = loopOverTail--;
            headCount--;
        }else {
            tailIndex--;
            tailCount--;
            loopOverHead++;
        }
        item = items[idx];
        items[idx]=null;
        itemCount--;
        if(itemCount==items.length/4){
            resize(items.length/2);
        }
        return item;
    }

    private void resize(int length){
        Item[] newItemsArr = (Item[])new Object[length];
        int i,j;
        for(i = items.length -1, j = 0; j < headCount; i--){
            if(items[i]!=null) {
                newItemsArr[length -1- j] = items[i];
                j++;
            }
        }
        loopOverHead=0;
        headIndex = length - headCount ;
        int k,l;
        for(k = 0, l = 0; l < tailCount; k++){
            if(items[k]!=null) {
                newItemsArr[l] = items[k];
                l++;
            }
        }
        tailIndex=tailCount;
        loopOverTail=length-1;
        items = newItemsArr;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item>{
        private int iteration = 0;
        private int iterHeadCount = headIndex;
        private int iterTailCount=0;
        @Override
        public boolean hasNext() {
            return (iteration < itemCount);
        }

        @Override
        public Item next() {
            if(iteration == itemCount){
                throw new NoSuchElementException("No more items");
            }
            Item item = null;
            int idx = items.length-iterHeadCount;
            if(iterHeadCount==0){
                idx=iterTailCount++;
            }else{
                iterHeadCount--;
            }
            iteration++;
            return items[idx];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not supported");
        }
    }
    public static void main(String[] args){
        Deque2<Integer> deque = new Deque2<>();
        System.out.println(deque.isEmpty());
        deque.addLast(0);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        System.out.println(deque.removeFirst());
        /*deck.addFirst("C");
        deck.addFirst("B");
        deck.addFirst("A");
        System.out.println(deck.removeFirst());
        System.out.println(deck.removeFirst());
        deck.addLast("D");
        System.out.println(deck.removeFirst());
        System.out.println(deck.removeLast());
        deck.addFirst("E");
        deck.addLast("F");
        System.out.println(deck.removeLast());

        //deck.addFirst("Start - ");
        int n = deck.size();
        //System.out.println(n);
        *//*for(String s : deck){
            System.out.println(s);
            deck.removeLast();
            deck.addFirst("a");
            deck.removeFirst();
            deck.addLast("b");

        }*//*
        for(int i=0; i<=11000;i++){
            if(i%2==0){
                deck.addFirst(i/2+"");
            }else if(i%3==0){
                deck.addLast(i/3+"");
            }else if(i%5==0){
                deck.removeLast();
            }else if(i%7==0){
                deck.removeFirst();
            }
        }*/

        for(int i=0; i<=5;i++){
            deque.addLast(i);
        }
        for(Integer s1: deque){
            System.out.println(s1);
        }
        for(int i=0;i<deque.size();i++){
           System.out.print(deque.removeFirst() +" ");
        }
      //  System.out.println(deck.removeLast());
       /* coursera.excer.Deque<String> anotherDeck = new coursera.excer.Deque<>();
        anotherDeck.addFirst("a");
        anotherDeck.addLast("b");
        anotherDeck.removeLast();
        System.out.println(deck.size());*//*
        for(String s1: deck){
            System.out.println(s1);
        }*/
        //deck.iterator().next();
        //deck.iterator().remove();
        //deck.removeLast();
        //deck.addFirst(null);
       // deck.addLast(null);

    }


}
