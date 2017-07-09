import java.util.HashMap;

public class Node{
    char value;
    HashMap<Character,Node> childNodes = new HashMap<Character, Node>();
    boolean isComplete;
    public Node(char value){
        this.value = value;
    }
}