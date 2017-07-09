package ctci;

/**
 * Created by 371865 on 3/11/2017.
 */
public class Q1_4ReplaceSpace {
    public static void main(String[] args){
        String s ="A B CD    ";
        s = replaceSpaceWith(s,6);
        System.out.println(s);
    }
    private static String replaceSpaceWith(String s,int trueLen){
        char[] sChars = s.toCharArray();
        int actualIndx = sChars.length;
        for(int i=trueLen -1; i > 0; i--){
            if(s.charAt(i) == ' '){
                sChars[--actualIndx] = '%';
                sChars[--actualIndx] = '0';
                sChars[--actualIndx] = '2';
            }else {
                sChars[--actualIndx] = s.charAt(i);
            }
        }
        return String.valueOf(sChars);
    }
}
