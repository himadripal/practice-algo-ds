package also.slns;

import java.util.Scanner;

/**
 * Created by 371865 on 12/15/2016.
 */
public class MakeAnagrams {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String a ="acdee";// in.next();
        String b = "abc"; //in.next();
        System.out.println(numberOfCharsToBeDeleted(a, b));
    }
    public static int numberOfCharsToBeDeleted(String a, String b){
        int number=0;
        int[] charsA = new int[26];
        int[] charsB = new int[26];


        for(int i=0;i<a.length();i++){
            char chatAtI = a.charAt(i);
            charsA[chatAtI -'a'] = charsA[chatAtI -'a'] +1;
        }
        for(int i=0;i<b.length();i++){
            char chatAtI = b.charAt(i);
            charsB[chatAtI -'a'] = charsB[chatAtI -'a'] +1;
        }
        for(int i=0; i<26;i++){
            int aCount = charsA[i];
            int bCount = charsB[i];
            if(aCount == bCount){
                continue;
            }else{
                int count = (aCount - bCount);
                count = count <0? -1 * count: count;
                number+=count;
            }
        }

        return number;
    }
}
