package also.slns;

import ctci.Q2_2FindKthToLastInLnkdList;

import java.util.Stack;

/**
 * Created by hpal on 12/15/2016.
 * Flyod's loop finding algo - tortise and hare
 */
public class LinkedListLoopAndDeleteNode {
    public static class Node{
        int data;
        Node next;
        public Node(int i){
            data = i;
            next = null;
        }
    }
    private static Node kThToLastElem(Node head, int k){
        if(k<0) return null;
        if(head==null) return null;
        Node current = head;
        Node currentPlusK = head;
        //move k ahead
        for(int j=0; j < k+1; j++){
            currentPlusK = currentPlusK.next;
        }
        while(currentPlusK != null){
            current = current.next;
            currentPlusK = currentPlusK.next;
        }
        return current;
    }

    public static void main(String[] args){
        /*Node head = new Node(10);
        Node prevNode = head;
        Node n = null;
        Node loopNode=null;
        for(int i=0; i < 10; i++){
            n = new Node(i);

            prevNode.next = n;
            prevNode = n;
        }
        //prevNode.next=head;
        // to create a cycle uncomment the following line and commnet, iterate calls and delete calls.
       // prevNode.next=head;
        System.out.println(hasCycle(head)?"YES":"NO");
        iterateOverLinkedList(head);
       // Node lastElem = kThToLastElem(head,0);
        //*deleteNode(10,head);
       /* System.out.println("After deletion");
        iterateOverLinkedList(head);*/
        /*Node nextToLast = kThToLastElem(head,9);
        System.out.println("first  - "+nextToLast.data);
        System.out.println();
        Node startOfLoop = determineStartOfLoop(head);
        if(startOfLoop!=null){
            System.out.println("Start of loop " +startOfLoop.data);
        }else {
            System.out.println("No Loop");
        }*/
        Node n1 = new Node(1);
        n1.next=new Node(4);
        n1.next.next= new Node(3);
        n1.next.next.next=new Node(5);

        Node n2 = new Node(9);
        //n2.next= new Node(8);
       // n2.next.next= new Node(4);

        //iterateOverLinkedList( addTwoNumbers(n1,n2));
        iterateOverLinkedList(n1);
        System.out.println();
        //iterateOverLinkedList(insertionSortList(n1));

        iterateOverLinkedList(removeNthFromEnd(n2,1));

    }

    /**
     * Detect if there is cycle. Print YES it true No otherwise
     * @param head
     * @return
     */
    static boolean hasCycle(Node head) {
        if(head==null) return false;
        //initialize with head for both
        Node oneHop=head,twoHop = head;
        while(true){
            if(oneHop!=null) {
                oneHop = oneHop.next; //1 hop
            } else {
                // if null means no loop
                return false;
            }
            if(twoHop.next != null) {
                twoHop = twoHop.next.next; // 2 hop
            } else {
                //if null meaning no loop
                return false;
            }
            //if any of them hits null - no loop
            if(twoHop == null || oneHop==null){
                return false;
            }
            //if they ever meet  - means loop exists
            if( oneHop == twoHop){
                return true;
            }
        }
    }

    /**
     * Iterate over the loop : infinite loop for cycle
     * @param head
     */
    static  void iterateOverLinkedList(Node head){
        int i=0;
        while(head != null && i++ <= 10){
            System.out.print(head.data +" ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * delete node, idea is transfer everything from the node.next to node and
     * make node.next dangling
     * @param data
     * @param head
     */
    static void deleteNode(int data,Node head){
        while(head !=null){
            if(head.data == data){
                //move the next node's data to this node
                //move next pointer to next.next
                //ideally making head.next ready for garbage collection.
                Node temp = head.next;
                head.data = head.next.data;
                head.next = head.next.next;
                temp = null; // making it ready for GC
                break;
            }
            // move the pointer to next node in the list
            head = head.next;
        }
    }

    private static Node addLists(
            Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        Node result = new Node(carry);
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        result.data = value % 10;
        if (l1 != null || l2 != null) {
            Node more = addLists(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }

    private static Stack<Integer> addTwoList(Node head1, Node head2){
        Stack<Integer> operand1 = new Stack<>();
        Stack<Integer> operand2 = new Stack<>();

        Stack<Integer> result = new Stack();
        while(head1!=null){
            operand1.push(head1.data);
            head1 = head1.next;
        }
        while(head2!=null){
            operand2.push(head2.data);
            head2=head2.next;
        }
        /*if(operand1.size()> operand2.size()){

       }*/
        int carry = 0;
        while(!operand1.isEmpty() && operand2.isEmpty()){
           // if(operand1.isEmpty() && )
            int i = operand1.pop();
            int j = operand2.pop();
            int sum = carry+i+j;
            result.push(sum % 10);
            if(sum>10){
                carry=1;
            }else {
                carry=0;
            }
        }
        if(carry>0){
            result.push(carry);
        }
        return result;

    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node result = null;
        Node prevNode = null;

        int carry=0;
        int sum=0;
        while(l1!=null || l2!=null){
            sum = carry;
            if(l1!=null){
                sum = sum+l1.data;
                l1=l1.next;
            }
            if(l2!=null){
                sum=sum+l2.data;
                l2 = l2.next;
            }
            if(sum>=10){
                carry = 1;
            }else{
                carry = 0;
            }

            if(result==null){
                Node node = new Node(sum%10);
                result=node;
                prevNode = result;
            }else{
                Node node = new Node(sum%10);
                prevNode.next = node;
                prevNode = node;
            }
            //l1=l1.next;
            //l2=l2.next;
        }
        if(carry==1){
            prevNode.next = new Node(carry);
        }
        return result;
    }

    static Node determineStartOfLoop(Node head){
        if(head==null) return null;
        Node oneHop=head,twoHop=head;
        while(true){
            if(twoHop.next==null) return null;
             twoHop=twoHop.next.next;
             oneHop=oneHop.next;
            //loop exists
            if(oneHop==twoHop) break;
        }
        //move oneHop to head;
        oneHop=head;
        while(twoHop!=null){
            oneHop=oneHop.next;
            twoHop=twoHop.next;
            if(oneHop==twoHop){
                return oneHop;
            }
        }
        return null;
    }

    public static Node insertionSortList(Node head) {

        if (head == null || head.next == null)
            return head;

        Node newHead = new Node(head.data);
        Node pointer = head.next;

        // loop through each element in the list
        while (pointer != null) {
            // insert this element to the new list

            Node innerPointer = newHead;
            Node next = pointer.next;

            if (pointer.data <= newHead.data) {
                Node oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            } else {
                while (innerPointer.next != null) {

                    if (pointer.data > innerPointer.data && pointer.data <= innerPointer.next.data) {
                        Node oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext;
                    }

                    innerPointer = innerPointer.next;
                }

                if (innerPointer.next == null && pointer.data > innerPointer.data) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }

            // finally
            pointer = next;
        }

        return newHead;
    }

    //private void hasCycle()
    public static Node removeNthFromEnd(Node head, int n) {
        if(n<0) return head;
        Node current=head;
        Node currentN=head;
        for(int i=1; i<=n+1; i++){
            if(currentN!=null) {
                currentN = currentN.next;
            }
        }
        while(currentN!=null){
            currentN=currentN.next;
            current=current.next;
        }
        if(current.next!=null)
        current.next=current.next.next;
        else{if(current==head) return null;}
        return head;
    }
}
