package ctci;

/**
 * Created by Himadri Pal (mehimu@gmail.com) on 6/25/2017.
 */
public class SimulationPutThread implements Runnable {
    BlockingQ<Integer> queue = null;
    Integer number=null;
    public SimulationPutThread(BlockingQ<Integer> queue,Integer number){
        this.queue = queue;
        this.number = number;
    }
    public void run(){
        try{
            queue.put(number);
            System.out.println("Added -" +number);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
