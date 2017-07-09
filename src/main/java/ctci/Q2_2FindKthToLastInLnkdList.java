package ctci;

/**
 * Created by hpal(mehimu@gmail.com) on 3/11/2017.
 */
public class Q2_2FindKthToLastInLnkdList {
    private class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args){


    }
    private static Node kThToLastElem(Node head, int k){
        if(k<0) return null;
        if(head==null) return null;
        Node current = head;
        Node currentPlusK = head;
        //move k ahead
        for(int j=0; j < k; j++){
            currentPlusK = currentPlusK.next;
        }
        while(currentPlusK != null){
            current = current.next;
            currentPlusK = currentPlusK.next;
        }
        return current;
    }
}
