package also.slns;

import java.util.Stack;

/**
 * Created by hpal(mehimu@gmail.com) on 1/26/2017.
 */
public class DijkstraTwoStack {
    private static Stack<Integer> value = new Stack<>();
    private static Stack<String> operands = new Stack<>();
    public DijkstraTwoStack(){

    }
    public static void main(String[] args) {
        String expression = "(1+(2*3)+(4/2))";
        for (int i = 0; i < expression.length(); i++) {
            String exChar = expression.charAt(i) + "";
            if (exChar.equals("(")) {
                continue;
            }else if (exChar.equals(")")) {
                calculate();
            } else if ("+*-/".contains(exChar)) {
                    operands.push(exChar);
            }else {
                    value.push(Integer.valueOf(exChar));
            }
        }
        while(!operands.isEmpty()){
            calculate();
        }
        System.out.println(value.pop());
    }
    private static void calculate(){
        int op2 = value.pop();
        int op1 = value.pop();
        String operand = operands.pop();
        if (operand.equals("+")) {
            value.push(op1 + op2);
        } else if (operand.equals("-")) {
            value.push(op1 - op2);
        } else if (operand.equals("*")) {
            value.push(op1 * op2);
        } else if (operand.equals("/")) {
            value.push(op1 / op2);
        }
    }

}
