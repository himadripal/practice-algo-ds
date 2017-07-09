import also.slns.ContactBookWithTries;

import java.util.*;

public class SolutionAll {
    public class Node{
        char value;
        HashMap<Character,Node> childNodes = null;
        boolean isComplete;
        public Node(){
            childNodes = new HashMap<Character, Node>();
            isComplete = false;
        }
    }
    public class Node2{
        Node2[] childNodes = null;
        boolean isComplete;
        public Node2(){
            childNodes = new Node2[26];
            isComplete = false;
        }
    }
    int wordCount = 0;
    Node root = new Node();
    Node2 root2 = new Node2();

    int matchCount = 0;

    Node traverser = null;
    Node2 traverser2 = null;
    Set<String> contactList = new TreeSet<String>();

    public static void main(String[] args) {
        ContactBookWithTries s = new ContactBookWithTries();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")){
               // s.add2(contact,s.root2);
            }else if(op.equals("find")){
               // s.find2(contact,s.root2);

            }
        }
    }
    public void add2(String word,Node2 root2){
        if(word == null || word.length()==0) return;
        if(contactList.contains(word)) return;
        for(int i=0; i < word.length();i++){
            if(i==0) {
                traverser2 = root2;
            }
            char oneChar = word.charAt(i);

            Node2 child = traverser2.childNodes[oneChar -'a'];
            if(child == null){
                child = new Node2();
                traverser2.childNodes[oneChar -'a'] = child;
            }
            if(i== word.length() -1){
                child.isComplete = true;
                wordCount++;
                contactList.add(word);
            }
            traverser2 = child;
            child = null;
        }
    }

    public void find2(String word,Node2 root2){
        if(wordCount==0){ System.out.println(0); return;}
        for(int i=0; i <word.length();i++){
            char oneChar = word.charAt(i);
            Node2 child = null;
            if(i==0) {
                traverser2 = root2;
            }
            if(traverser2 != null) {
                child = traverser2.childNodes[oneChar -'a'];
                if (child != null) {
                    traverser2 = child;
                    continue;
                }else{
                    traverser2 = null;
                    break;
                }
            }
            traverser2 = child;
            child = null;
        }
        matchCount = 0;
        if(traverser2 != null && traverser2.isComplete) ++matchCount;
        iterateOverTheTreeCount2(traverser2);
        System.out.println(matchCount);

    }
    void iterateOverTheTreeCount2(Node2 startNode){
        if(startNode != null){
            boolean isEmpty = true;
            for(Node2 node : startNode.childNodes){
                if(node != null){
                    isEmpty = false;
                    if(node.isComplete) ++matchCount;
                    iterateOverTheTreeCount2(node);
                }
            }
            if(isEmpty) return;

        }
    }

    public void add(String word,Node root){
        if(word == null || word.length()==0) return;
        for(int i=0; i < word.length();i++){
            if(i==0) {
                traverser = root;
            }
            char oneChar = word.charAt(i);
            Node child = traverser.childNodes.get(oneChar);
            if(child == null){
                child = new Node();
                traverser.childNodes.put(oneChar,child);
            }
            if(i== word.length() -1){
                child.isComplete = true;
                wordCount++;
            }
            traverser = child;
        }
    }
    public void find(String word,Node root){
        if(wordCount==0){ System.out.println(0); return;}
        for(int i=0; i <word.length();i++){
            char oneChar = word.charAt(i);
            Node child = null;
            if(i==0) {
                traverser = root;
            }
            if(traverser != null) {
                child = traverser.childNodes.get(oneChar);
                if (child != null) {
                    traverser = child;
                    continue;
                }else{
                    traverser = null;
                    break;
                }
            }
            traverser = child;
        }
        matchCount = 0;
        if(traverser != null && traverser.isComplete) ++matchCount;
        iterateOverTheTreeCount(traverser);
        System.out.println(matchCount);

    }
    void iterateOverTheTreeCount(Node startNode){
        if(startNode != null){
            if(startNode.childNodes.isEmpty()){
                return;
            }
            for(Character a : startNode.childNodes.keySet()){
                if(startNode.childNodes.get(a).isComplete){
                    ++matchCount;
                }
                iterateOverTheTreeCount(startNode.childNodes.get(a));
            }
        }
    }
}
