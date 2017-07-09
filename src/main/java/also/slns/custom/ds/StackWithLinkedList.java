package also.slns.custom.ds;

/**
 * Created by Himadri Pal (mehimu@gmail.com) on 6/20/2017.
 */
public class StackWithLinkedList<Item> {
    private class Node {
        Item item;
        Node next;
        public Node(Item item){
            this.item=item;
            this.next = null;
        }
    }
    private Node first;
    private int count;

    public StackWithLinkedList(){
        first = null;
        count=0;
    }

    public void push(Item item){
        Node n= new Node(item);
        if(isEmpty()) first = n;
        else{
            n.next=first;
            first=n;
        }
        count++;
    }
    public Item pop(){
        Item item = first.item;
        Node temp = first;
        first = first.next;
        temp=null;
        count--;
        return item;
    }
    public boolean isEmpty(){
        return count==0;
    }

    public static void main(String[] args){
        StackWithLinkedList stack = new StackWithLinkedList();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.count);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
