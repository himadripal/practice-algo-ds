package coursera.excer;

/**
 * Created by hpal(mehimu@gmail.com) on 1/4/2017.
 */
public class StacksWithArray {
    private int count=0;
    int[] elements = null; // making this default just to see the arr length vs count during resize call

    public StacksWithArray(){
        elements = new int[1];
    }

    public boolean isEmpty(){
        return count==0;
    }

    public void push(int item){
        if(count == elements.length) { resize(elements.length *2);}
        elements[count] = item;
        count++;
    }

    public int pop(){
        if(!isEmpty())count --;
        int item = elements[count];
        if(count == elements.length/4) { resize(elements.length/2);};
        return item;
    }
    public int size(){
        return count;
    }

    private void resize(int newLength){
        int[] newArr = new int[newLength];
        System.arraycopy(elements,0,newArr,0,count);
        elements = newArr;
    }

    public static void main(String[] args){
        StacksWithArray s = new StacksWithArray();
        System.out.println("isEmpty()"+ s.isEmpty());
        for(int i=0; i <100; i++){
           System.out.println("count ->"+s.size()+"arr length ->"+s.elements.length);
        }
        System.out.println("POP Starts");
        for(int i=0; i <100; i++){
            s.pop();
            System.out.println("count ->"+s.size()+"arr length ->"+s.elements.length);

        }
    }
}
