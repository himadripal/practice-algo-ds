package ctci;

/**
 * Created by 371865 on 3/11/2017.
 */
public class Q1_5CompressWithCharCount {

    public static void main(String[] args){
        String str = "aaaaabbbbbccccccccccdddddddddd";
        String compressedStr = compressStringWithOccurance(str);
        if(str.length() > compressedStr.length()){
            System.out.println(compressedStr);
        }else {
            System.out.println(str);
        }
    }

    /**
     * character set size of the string
     * @param str
     */
    private static String compressStringWithOccurance(String str){
        int[] charSet = new int[26];
        StringBuffer sbf = new StringBuffer();

        for(int i=0; i < str.length(); i++){
            char c = str.charAt(i);
            charSet[c -'a'] = charSet[c-'a']+1;
        }
        for(int i=0; i < charSet.length; i++){
            char cAti = (char) ('a'+i);
            if(charSet[i]!=0){
                sbf.append(cAti);
                sbf.append(charSet[i]);
            }
        }
        return sbf.toString();
    }

}
