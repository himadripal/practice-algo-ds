package coursera.excer;

/**
 * Created by hpal(mehimu@gmail.com) on 1/4/2017.
 */
public class QueueWithLinkedList {
    private Node tail;
    private Node head;
    private int count =0;
    private class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void enQueue(int data){
        count++;
        Node n = new Node(data);
        if(tail != null) tail.next = n;
        tail = n;
        if(isEmpty()) head=tail;
    }

    public int deQueue(){
        if(isEmpty()) throw new IllegalArgumentException("Queue is Empty");
        int data = head.data;
        Node tempHead = head;
        head = head.next;
        tempHead = null;// to make it ready for gc
        count --;
        return data;
    }
    public int size(){
        return count;
    }

    public static void main(String[] args){
        QueueWithLinkedList queue = new QueueWithLinkedList();
        System.out.println(queue.isEmpty());
        queue.enQueue(1);
        System.out.println(queue.deQueue());
        queue.enQueue(2);
        queue.enQueue(3);
        int size= queue.size();
        System.out.println("size - "+ size);
        for(int i=0; i < size; i++){
            System.out.print(queue.deQueue()+",");
        }
    }

}
