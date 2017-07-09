package also.slns;

/**
 * Created by 371865 on 3/11/2017.
 */
public class ReverseAString {
    public static void main(String[] args){
        String s = reverseAString("abcd");
        System.out.println(s);
    }

    public static String reverseAString(String s){
         char[] sChars = s.toCharArray();
        for(int i=0,j=s.length()-1;i <=j;i++,j--){
            swap(sChars,i,j);
        }
        return String.valueOf(sChars);
    }

    private static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
