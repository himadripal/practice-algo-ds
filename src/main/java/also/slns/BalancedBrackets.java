package also.slns;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Himadri Pal on 12/15/2016.
 *  Hacker Rank
 *
 *  A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left
 of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
 A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.

 Sample Input
 3
 {[()]}
 {[(])}
 {{[[(())]]}}

 Sample Output
 YES
 NO
 YES
 *
 *
 *
 * Idea is similar to Dijkstra's two stack algorithm but using one stack,
 *
 */
public class BalancedBrackets {

    public static boolean isBalanced(String expression) {
        //if expression is null or empty
        if(expression==null || expression.isEmpty()) return true;
        //if length of expression is odd return false
        if(expression.length()%2 !=0) return false;
        //hold the matching brackets in a hashmap
        HashMap<Character,Character> matchingBrackets = new HashMap<Character,Character>();
        matchingBrackets.put('(',')');
        matchingBrackets.put('{','}');
        matchingBrackets.put('[',']');

        Stack<Character> openBrackets = new Stack<Character>();
        for(int i=0; i < expression.length(); i++){
            char bracket = expression.charAt(i);
            //encouter closing bracket, then pop the stack and
            // find matching closing bracket of the one poped
             if(bracket == ']' || bracket=='}' || bracket==')') {
                if(openBrackets.isEmpty()) return false;
                if(matchingBrackets.get(openBrackets.pop()) == bracket){
                    continue;
                }else{
                    return false;
                }
            }
            //encounter open bracket, then push to stack
            if(bracket == '[' || bracket=='{' || bracket=='('){
                openBrackets.push(bracket);
            }
        }
        //edge case, if any all are open brackets..
        //if(expression.length() == openBrackets.size()) return false;
        //if the stack is not empty return false.
        if(!openBrackets.isEmpty()) return false;
        //in all other cases return true.
        return true;
    }

    public static void main(String[] args) throws Exception{

      // List<String> output =  Files.readAllLines( Paths.get(also.slns.BalancedBrackets.class.getResource("/input.txt").toURI()));
       System.out.println((isBalanced("{{}(")) ? "YES" : "NO" );
    }
}
