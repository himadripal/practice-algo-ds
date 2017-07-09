package ctci;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Himadri Pal (mehimu@gmail.com) on 6/25/2017.
 */
public class BlockingQ<Item> {
    int capacity;
    Queue<Item> queue;

    public BlockingQ(int capacity){
        queue = new LinkedList<Item>();
        this.capacity=capacity;
    }
    public void put(Item item) throws InterruptedException{

        synchronized (queue){
            while(queue.size()>=capacity){
                System.out.println("going to wait as queue is full");
                queue.wait();
            }
            queue.notifyAll();
            System.out.println("Notified from put with add - "+ item);
            queue.add(item);

        }
    }

    public Item get() throws InterruptedException{
        Item item=null;

        synchronized(queue){
            while(queue.size()==0){
                System.out.println("going to wait as queue is empty");
                queue.wait();
            }
            queue.notifyAll();
            item = queue.poll();
        }
        return item;
    }

   /* private class SimulationPutThread implements Runnable{
        BlockingQ<Integer> queue = null;
        int count ;
        public SimulationPutThread(BlockingQ<Integer> queue){
                this.queue = queue;
        }
        public void run(){
            try{queue.put(++count);}
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private class SimulationGetThread implements Runnable{
        BlockingQ<Integer> queue = null;
        public SimulationGetThread(BlockingQ<Integer> queue){
            this.queue = queue;
        }
        public void run(){
            try{queue.get();}
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }*/

    public static void main(String[] args){
       BlockingQ<Integer> queue = new BlockingQ<>(3);

       try{
           Thread t1 = new Thread(new SimulationGetThread(queue),"t1");
           Thread t2 = new Thread(new SimulationGetThread(queue),"t2");
           Thread t3 = new Thread(new SimulationGetThread(queue),"t3");

           Thread t4 = new Thread(new SimulationPutThread(queue,1),"t4");
           Thread t5 = new Thread(new SimulationPutThread(queue,2),"t5");
           Thread t6 = new Thread(new SimulationPutThread(queue,3),"t6");
           Thread t7 = new Thread(new SimulationPutThread(queue,4),"t7");
           //t1.start();
           t4.start();
           //t2.start();
           t5.start();
          // t3.start();
           t6.start();
           t7.start();

       }catch (Exception e){
           e.printStackTrace();
       }
    }

}
