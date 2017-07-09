package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Himadri Pal (mehimu@gmail.com) on 6/6/2017.
 * Interprets Command Line and prints output in console
 */
public class CLIProgram {
    //only supporting these operator, add more here and associated logic in the code
    public enum Operator{
        replace,
        swap,
        uppercase,
        reverse
    }


    public static void main(String[] args){
        try{

            for(String s : createAInputList()){
                System.out.println(commandLineInterpret(s));
            }
            //uncomment these lines if input is file
            /*
            List<String> input =  Files.readAllLines( Paths.get(CLIProgram.class.getResource("/comcast-input.txt").toURI()));
            for(String line : input){
                System.out.println(commandLineInterpret(line));
            }
            */

        }catch (Exception e){

            System.out.println(e.getMessage());
        }

    }

    private static List<String> createAInputList(){

        List<String> inputList = new ArrayList<>();
        inputList.add("Sam loves cats #replace cat dog");
        inputList.add("Minions are yellow creatures #swap 3 1");
        inputList.add("My food tastes like chicken #uppercase last");
        inputList.add("Paper beat rock #reverse");
        inputList.add("No operator");
        inputList.add("No Arguments #replace");

        return inputList;
    }


    private static String commandLineInterpret(String line){
        String output=line;
        if(line!=null && !line.isEmpty()){
            //find the occurance of # for operator;

            int operatorStart = line.lastIndexOf("#");
            //if no operator means operatorStart = -1 return orignial string
            if(operatorStart == -1){
                return line;
            }

            String inputText = line.substring(0,operatorStart);
            //trim the last space
            if(inputText!=null && !inputText.isEmpty()){
                inputText = inputText.trim();
            }
            String operatorAndArgs = line.substring(operatorStart+1,line.length());

            output = convertLine(inputText,operatorAndArgs.split(" "));
        }
        return output;
    }

    /**
     * Converts a line based on operator and arguments provided
     * if no operator, original string is output ed
     * @param inputText
     * @param opsAndArgs
     * @return
     */
    private static String convertLine(String inputText, String[] opsAndArgs){
            String output = inputText;
            String operation = opsAndArgs[0];

            //TO-DO implement stategy pattern to dynamically change the method based on argument
            // should have different algo for replace,swap,uppercase and reverse
            // for the time, implmented with the pattern
            if(Operator.replace.name().equals(operation)){
                output = replace(inputText, opsAndArgs);
            }else if(Operator.swap.name().equals(operation)){
                output = swapInput(inputText, opsAndArgs);
            }else if(Operator.uppercase.name().equals(operation)){
                output = upperCase(inputText, opsAndArgs);
            }else if(Operator.reverse.name().equals(operation)){
                output = reverseInput(inputText);
            }

        return output;
    }

    private static String reverseInput(String inputText) {
        String output;
        String[] inputArr = inputText.split(" ");
        reverse(inputArr);
        output = combine(inputArr);
        return output;
    }

    private static String upperCase(String inputText, String[] opsAndArgs) {
        String output;
        if(opsAndArgs.length < 2) {
            throw new IllegalArgumentException("uppercase needs 1 arguments");
        }
        String arg = opsAndArgs[1];
        String[] inputArr = inputText.split(" ");
        if("last".equals(arg)){

            inputArr[inputArr.length-1] = inputArr[inputArr.length-1].toUpperCase();
        }else if("first".equals(arg)){
            inputArr[0] = inputArr[0].toUpperCase();
        }
        output=combine(inputArr);
        return output;
    }

    private static String swapInput(String inputText, String[] opsAndArgs) {
        String output;
        if(opsAndArgs.length < 3) {
            throw new IllegalArgumentException("swap needs two arguments");
        }
        String[] inputArr = inputText.split(" ");
        //TO-DO - catch NumberFormatException here
        int swapArg1 = Integer.valueOf(opsAndArgs[1]) -1 ; // -1 because array is  indexed from zero
        int swapArg2 = Integer.valueOf(opsAndArgs[2])- 1;  // -1 because array is  indexed from zero
        swap(inputArr,swapArg1,swapArg2);
        output = combine(inputArr);
        return output;
    }

    private static String replace(String inputText, String[] opsAndArgs) {
        String output;
        if(opsAndArgs.length < 3) {
            throw new IllegalArgumentException("replace needs two arguments");
        }
        output = inputText.replaceAll(opsAndArgs[1],opsAndArgs[2]);
        return output;
    }

    private  static void swap(String[] input,int i, int j){
        String temp = input[i];
        input[i]=input[j];
        input[j]=temp;
    }

    private static void reverse(String[] arr){
        for(int i=0,j=arr.length-1; i<=j; i++,j--){
            swap(arr,i,j);
        }
    }

    private static String combine(String [] input){
        StringBuilder builder = new StringBuilder();
        for(String s : input){
            builder.append(s);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}

