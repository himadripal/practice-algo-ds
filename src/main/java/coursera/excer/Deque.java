package coursera.excer;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by hpal(mehimu@gmail.com) on 1/19/2017.
 */
public class Deque<Item> implements Iterable<Item>{
    private Item[] items;
    private int head;
    private int tail;
    private int count;
    public Deque(){
        items = (Item[])new Object[4];
        head=1;
        tail=2;
    }

    public boolean isEmpty(){
        return count==0;
    }
    public int size(){
        return count;
    }

    public void addFirst(Item item){
        if(item==null) throw new NullPointerException("Item is null");
        if(count==items.length){
            resize(items.length*2);
        }
        if(head==-1){
            if(count <= items.length/2){
                //rearrange
                resize(items.length);
            }else{
                resize(items.length*2);
            }
        }
        items[head--]=item;
        count++;
    }

    public Item removeFirst(){
        if(isEmpty()) throw new NoSuchElementException("No more elements");
        if(count>4 && count==items.length/4){
            resize(items.length/2);
        }
        Item item;
        item=items[++head];
        items[head] = null;
        count--;
        return item;
    }

    public void addLast(Item item){
        if(item==null) throw new NullPointerException("Item is null");
        if(count==items.length){
            resize(items.length*2);
        }
        if(tail==items.length){
            if(count <= (items.length/2)){
                //rearrange
                resize(items.length);
            }else{
                resize(items.length*2);
            }
        }
        items[tail++]=item;
        count++;
    }

    public Item removeLast(){
        if(isEmpty()) throw new NoSuchElementException("No more elements");
        if(count>4 && count==items.length/4){
            resize(items.length/2);
        }
        Item item;
        item=items[--tail];
        items[tail] = null;
        count--;
        return item;
    }

    private void resize(int length){
        Item[] newItems = (Item[])new Object[length];

        int starIdx=length/4;

        for(int i=head+1;i<tail;i++){
            if(items[i]!=null){
                newItems[starIdx++]=items[i];
            }
        }
        head = length/4-1;
        tail=starIdx;
        items=newItems;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item>{
        private int iteration =0;
        private int headIdx=head;
        @Override
        public boolean hasNext() {
            return iteration < count;
        }

        @Override
        public Item next() {
            if(iteration >= count) throw new NoSuchElementException("No more elements");
            iteration++;
            return items[++headIdx];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported");
        }
    }
    public static void main(String[] args){
        Deque<Integer> deque = new Deque<>();
        /*deque.addFirst(0);
        deque.addFirst(1);
        System.out.println(deque.isEmpty());
        System.out.println( deque.removeLast() ) ;//    ==> 0
        deque.addFirst(4);*/

        for(int i=0; i < 500; i++){
            if(i%5==0) deque.addFirst(i+5);
            if(i%11==0) System.out.println(deque.removeLast());
            if(i%2==0) deque.addLast(i+2);
            if(i%7==0) System.out.println(deque.removeFirst());
        }
        for(int i=0; i < 5; i++){
            deque.addLast(i+10);
        }
        for(int i=0;i<10;i++){
            if(i%2==0)
            System.out.println(deque.removeFirst());
            else
                System.out.println(deque.removeLast());
        }
        System.out.println("From Iterator");
        for(Integer i :deque){
            System.out.println(i);
        }
        Iterator<Integer> iter1 = deque.iterator();
        Iterator<Integer> iter2 = deque.iterator();
        while(iter1.hasNext()){
            System.out.println(iter1.next());

            while(iter2.hasNext()){
                System.out.println(iter2.next());
            }
        }
       // for(int i=0;i<5;i++){
          // System.out.println(deque.removeLast());
       // }

       /* coursera.excer.Deque<String> anotherDeck = new coursera.excer.Deque<>();
       for(int i=0; i <100; i++){
            try {
                int random = StdRandom.uniform(4);
                switch (random) {
                    case 0: {
                        System.out.println("addFirst");
                        anotherDeck.addFirst("O is add first");
                        break;
                    }
                    case 1: {
                        System.out.println("removeLast");
                        System.out.println(anotherDeck.removeLast());
                        break;
                    }
                    case 2: {
                        System.out.println("addLast");
                        anotherDeck.addLast("2 is add Last");
                        break;
                    }
                    default: {
                        System.out.println("removeFirst");
                        System.out.println(anotherDeck.removeFirst());
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }*/
        //deque.removeLast();
             /*   deque.addLast(3);
                deque.addLast(4);
                deque.addLast(5);
        deque.addFirst(2);
                deque.removeFirst();
        deque.addFirst(1);
        deque.addLast(6);*/

        // 2 is add Last

        deque.addLast(1);
        deque.addLast(2);
        for(Integer i : deque){
            System.out.println(i);
        }

        String pattern = "^(877|800|866|888)\\d+$";
        System.out.println("8000000".matches(pattern));

    }
}
