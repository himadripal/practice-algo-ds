import java.util.HashMap;

/**
 * Created by 371865 on 3/22/2017.
 */
public class TrieTryOut {
    public void insert(Node root, String key){
        Node traversingNode=root;
        for(int i =0; i < key.length(); i++) {
            char c = key.charAt(i);
            Node childNode = traversingNode.childNodes.get(c);
            if (childNode == null) {
                childNode = new Node(c);
                traversingNode.childNodes.put(c, childNode);
            }
            if(i==key.length()-1) {
                childNode.isComplete=true;
            }
            traversingNode=childNode;
        }
    }
    public int findWord(Node root, String key){
        Node traveseringNode = root;
        int position =-1;
        int i=0;
        for(i=0; i< key.length(); i++){
           char c = key.charAt(i);
           Node childNode = traveseringNode.childNodes.get(c);
           if(childNode==null){
               return position;
           }
           if(childNode.isComplete==true) {
               position=i;
           }
           traveseringNode =childNode;
        }
        return position;
    }

    public boolean isPossibleToFormWord(Node root, String word){
        boolean result = false;

        int position = findWord(root,word);
        if(position==-1) return false;
        if(position+1==word.length())return true;
        int nextPosition = findWord(root,word.substring(position+1,word.length()));
        if(nextPosition==-1) return false;
        if(nextPosition+1==word.length()) return true;
        if(position+nextPosition+2==word.length()) return true;

        return result;
    }

    public static void main(String[] args){
        TrieTryOut trie = new TrieTryOut();
        Node root = new Node(Character.MIN_VALUE);
        String[] words = {"tojo", "is", "good","boy"};
        for(int i=0; i< words.length;i++){
            trie.insert(root,words[i]);
        }
        System.out.println(trie.isPossibleToFormWord(root,"tom"));
    }

}
