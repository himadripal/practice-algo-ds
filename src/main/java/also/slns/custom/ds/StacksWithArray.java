package also.slns.custom.ds;

/**
 * Created by Himadri Pal (mehimu@gmail.com) on 6/20/2017.
 */
public class StacksWithArray<Item> {
    Item[] items;
    int count;
    public StacksWithArray(){
        items =(Item[]) new Object[1];
    }
    public void push(Item item){
        if(items.length==count){
            resize(2*count);
        }
        items[count++]=item;
    }

    public Item pop(){
        Item item = items[--count];
        if(items.length/4==count){
            resize(2*count);
        }
        return item;
    }

    public boolean isEmpty(){ return count==0;}
    public int size(){return count;}
    private void resize(int size){
        System.out.println("new size -"+size+" : count -"+count);
        Item[] newItems = (Item[]) new Object[size];
        for(int i=0; i<count; i++){
            newItems[i]=items[i];
        }
        items=newItems;
    }

    public static void main(String[] args){
        StacksWithArray<Integer> stack = new StacksWithArray<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
