package ctci;

/**
 * Created by Himadri Pal (mehimu@gmail.com) on 6/25/2017.
 */
public class SimulationGetThread implements Runnable {
    BlockingQ<Integer> queue = null;
    public SimulationGetThread(BlockingQ<Integer> queue){
        this.queue = queue;
    }
    public void run(){
        try{
            System.out.println("polled - " +queue.get());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
