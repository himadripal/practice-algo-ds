import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 371865 on 12/5/2016.
 */
public class Tries {


    void addWord(String word,Node root){
        if(word == null || word.length()==0) return;
        char oneChar = word.charAt(0); //take the first letter
            if(root.value == oneChar){
                HashMap<Character,Node> childNodes = root.childNodes;
                if(!root.childNodes.isEmpty()){
                    for(Character eachChild : root.childNodes.keySet()){
                        addWord(word.substring(1),root.childNodes.get(eachChild));
                    }
                }else{
                    Node n = new Node(oneChar);
                    root.childNodes.put(oneChar,n);
                    if(word.length() ==1 ){
                        n.isComplete = true;return;
                    }else{
                        addWord(word.substring(1),n);
                    }
                }
            }else{
               Node n = new Node(oneChar);
                root.childNodes.put(oneChar,n);
                if(word.length() ==1 ){
                    n.isComplete = true;return;
                }else{
                    addWord(word.substring(1),n);
                }
            }

    }

   Node findMatchingWords(String prefix,Node root){
        if(!root.childNodes.isEmpty()){
            char oneChar= prefix.charAt(0);
            Node matchingNode = root.childNodes.get(oneChar);
            if(matchingNode == null){
                root = null;return null;
            }else{
                if(prefix.length()==1) {root = matchingNode; return null;}
                findMatchingWords(prefix.substring(1),matchingNode);
            }
        }else {
            root = null;
        }
        return root;
    }





    public void addWord2(String word,Node root){
        Node traverser = root;
        if(word == null || word.length()==0) return;
        for(int i=0; i < word.length();i++){
            /*if(i==0) {
                traverser = root;
            }*/
            char oneChar = word.charAt(i);
            Node child = traverser.childNodes.get(oneChar);
            if(child == null){
               child = new Node(oneChar);
               traverser.childNodes.put(oneChar,child);
            }
            if(i== word.length() -1){
                child.isComplete = true;
            }
            traverser = child;
        }
    }

    public void findWords2(String word,Node root){
        Node traverser=root;
        //StringBuilder sbd = new StringBuilder(word);
        List<String> outList = new ArrayList<String>();
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
        sbd = new StringBuilder(word);
        if(traverser != null && traverser.isComplete) outList.add(sbd.toString());
        iterateOverTheTree(traverser,word,outList);
        for(String s : outList){
            System.out.println(s);
        }
        count =0;
        if(traverser != null && traverser.isComplete) ++count;
        iterateOverTheTreeCount(traverser,word);
        System.out.println(count);
    }

    StringBuilder sbd = null;
    void iterateOverTheTree(Node startNode,String prefix,List<String> outList){
        if(startNode != null){
            if(startNode.childNodes.isEmpty()){
               sbd = new StringBuilder(prefix);
               return;
           }
           for(Character a : startNode.childNodes.keySet()){
               sbd.append(a);
               if(startNode.childNodes.get(a).isComplete){
                   outList.add(sbd.toString());
               }
               iterateOverTheTree(startNode.childNodes.get(a),prefix,outList);
           }
       }
    }

    int count = 0;
    void iterateOverTheTreeCount(Node startNode,String prefix){
        if(startNode != null){
            if(startNode.childNodes.isEmpty()){
                return;
            }
            for(Character a : startNode.childNodes.keySet()){
                //sbd.append(a);
                if(startNode.childNodes.get(a).isComplete){
                    ++count;
                }
                iterateOverTheTreeCount(startNode.childNodes.get(a),prefix);
            }
        }
       // return count;
    }



    public static void main(String[] args){
        Tries t = new Tries();
        Node n = new Node(Character.MIN_VALUE);
        t.addWord2("s",n);
        t.addWord2("ss",n);
        t.addWord2("sss",n);
        t.addWord2("ssss",n);
        t.addWord2("car",n);

        t.addWord2("carpool",n);
        t.addWord2("cathouse",n);
        //t.findWords2("ca",n);
        t.findWords2("car",n);
      //System.out.print(t.findAllMatchingWords("hak", n).size());
        t.findWords2("s",n);
    }
}

