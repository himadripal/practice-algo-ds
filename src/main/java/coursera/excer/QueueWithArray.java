package coursera.excer;

/**
 * Created by hpal(mehimu@gmail.com) on 1/4/2017.
 */
public class QueueWithArray {
    private int[] elements;
    private int tail;
    private int head;
    int count=0;

    public QueueWithArray(){
        elements = new int[1];
        tail=0;
        head=0;
    }

    public boolean isEmpty(){
        return count==0;
    }

    public void enQueue(int data){
        count++;
        elements[tail] = data;
        tail++;
        if(count == elements.length){ resize(elements.length*2,head,count);}

    }

    public int deQueue(){
        if(!isEmpty()){
            count--;
        }
        int data = elements[head++];
        if(count == elements.length/4){ resize(elements.length/2,head,count);}
        return data;
    }

    private void resize(int newLength,int start,int length){
        int[] newArr = new int[newLength];
        System.arraycopy(elements,start,newArr,0,count);
        elements = newArr;
        head=0;
        tail=count;
    }
    public int size(){
        return count;
    }

    public static void main(String[] args){
        QueueWithArray queue = new QueueWithArray();
        System.out.println(queue.isEmpty());
        queue.enQueue(1);
        queue.deQueue();
        queue.enQueue(3);
        int size= queue.size();
        System.out.println("size - "+ size);
        for(int i=0; i < size; i++){
            System.out.print(queue.deQueue()+",");
        }

        for(int i=0; i <100; i++){
            queue.enQueue(i);
            System.out.println("count ->"+queue.size()+"arr length ->"+queue.elements.length);
        }
        System.out.println("POP Starts");
        for(int i=0; i <100; i++){
           // System.out.println(queue.deQueue()+",");
            queue.deQueue();
            System.out.println("count ->"+queue.size()+"arr length ->"+queue.elements.length);

        }
    }
}
