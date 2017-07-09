package also.slns;

import java.util.*;

/**
 *  Tries  - tree - maintain and search contact book
 */
public class ContactBookWithTries {

    public class Node {
        Node[] childNodes = null;
        boolean isComplete;
        // important - keep track of the complete word below this node
        int completeWordCount;
        public Node(){
            childNodes = new Node[26];
            isComplete = false;

        }
    }
    Hashtable<Node,String> nodeCountTable = new Hashtable<Node, String>();
    int wordCount = 0;
    Node root = new Node();

    public void addContact(String word, Node root){
        //return null if word itself is null
        if(word == null || word.length()==0) return;

        //find if exists
        Node child = root.childNodes[word.charAt(0) -'a'];
        //add if not
            if(child == null){
                child = new Node();
                root.childNodes[word.charAt(0) -'a'] = child;
                addContact(word.substring(1),child);
            }else{
                //recursive call,as we found the first char
                addContact(word.substring(1),child);
            }
            child.completeWordCount++;
            //stop the recursion
            if(word.length() == 1){
                child.isComplete = true;
                wordCount++;
                //contactList.add(word);
                return;
            }

    }


     public Node findNode(String word, Node node){
         // find child
           Node child = node.childNodes[word.charAt(0) - 'a'];
         // break the loop if last char
            if(word.length()==1) return child;
            if(child != null){
                    return findNode(word.substring(1),child);
            }else{
                    return null;
            }
     }

     public void findContact(String word, Node root2){
        Node node = findNode(word,root2);
        System.out.println(node.completeWordCount) ;

    }
        public static void main(String[] args) {
        ContactBookWithTries s = new ContactBookWithTries();

        //Scanner in = new Scanner(System.in);
        //int n = in.nextInt();

        s.addContact("s",s.root);
        s.addContact("ss",s.root);
        s.addContact("sss",s.root);
        s.addContact("ssss",s.root);
            s.addContact("cat",s.root);
            s.addContact("c",s.root);
            s.addContact("car",s.root);
            s.addContact("cas",s.root);




            s.findContact("s",s.root);
            s.findContact("c",s.root);
            s.findContact("ca",s.root);
            s.findContact("car",s.root);

        /*for(int a0 = 0; a0 < 80000000; a0++){
            String op = "";
            String contact = "";
            if(a0%2==0) op="add"; else op="find";
            if(a0%5==0) contact="ssss"; else contact="tttt";
            if(op.equals("add")){
                s.add2(contact,s.root2);
            }else if(op.equals("find")){
                s.find2(contact,s.root2);

            }
        }*/

            System.out.println("himadri".substring(1,2));

                    /*String str= new String("quick brown fox jumps over the lazy dog");
                    System.out.println("Substring starting from index 15:");
                    System.out.println(str.substring(15));
                    System.out.println("Substring starting from index 15 and ending at 20:");
                    System.out.println(str.substring(15, 20));*/


    }
 }
