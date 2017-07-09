package coursera.excer;

/**
 * Created by hpal(mehimu@gmail.com) on 1/3/2017.
 */
public class StackWithNodes {
    private class Node{
        int item;
        Node next;
        public Node(int item){
            this.item = item;
            next = null;
        }
    }
    private Node first = null;
    private int count=0;
    public StackWithNodes(){

    }

    public int pop(){
        int item = first.item;
        first = first.next;
        if(!isEmpty()) count--;
        return item;
    }
    public void push(int item){
        Node n = new Node(item);
        n.next = first;
        first = n;
        count++;
    }
    public boolean isEmpty(){
        return (first==null);
    }
    public int size(){
        return  count;
    }

    public static void main(String[] args){
        StackWithNodes s = new StackWithNodes();
        System.out.println("isEmpty()"+ s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        int count = s.size();
        System.out.println("size -"+ count);
        for(int i=0; i < count; i++){
            System.out.print(s.pop()+ ",");
        }
    }
}
