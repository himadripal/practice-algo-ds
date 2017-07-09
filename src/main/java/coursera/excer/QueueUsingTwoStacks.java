package coursera.excer;

import java.util.Stack;

import java.util.Scanner;

/**
 * Created by hpal(mehimu@gmail.com) on 1/26/2017.
 */
public class QueueUsingTwoStacks {
    private static class MyQueue<Item> {
        private Stack<Item> enQueueStack = new Stack<Item>();
        private Stack<Item> deQueueStack = new Stack<Item>();
        private int count =0;
        private Item lastPeek = null;
        //private boolean deQueued = false;
        //private boolean enQueued = false;
        //private boolean peeked = false;
        public MyQueue() {

        }

        public void enqueue(Item item) {
            if(count==0 && deQueueStack.isEmpty()){
                lastPeek=item;
            }
            enQueueStack.push(item);
            count++;
        }

        private void reFillEnqueStack() {
            while (!deQueueStack.isEmpty()) {
                enQueueStack.push(deQueueStack.pop());
            }
        }

        public void dequeue() {
            if(deQueueStack.isEmpty()) {
                fillUpDequeseStack();
            }
            deQueueStack.pop();
            count--;
            /*if(!deQueueStack.isEmpty()) {
                lastPeek=deQueueStack.peek();
            } else {
                lastPeek=null;
            }*/

        }

        private void fillUpDequeseStack() {
            while (!enQueueStack.isEmpty()) {
                deQueueStack.push(enQueueStack.pop());
            }
            //deQueued=true;
        }

        public Item peek() {
            if(deQueueStack.isEmpty() && count>0){
                fillUpDequeseStack();
            }
            lastPeek=deQueueStack.peek();
            return lastPeek;
            //return item;
        }
    }

    public static void main(String[] args){
        long t1 = System.currentTimeMillis();
        Scanner scan = new Scanner(System.in);
        MyQueue<Integer> queue = new MyQueue<>();
        int n = scan.nextInt();


        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
        System.out.println(System.currentTimeMillis()-t1);
    }
}
