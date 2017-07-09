package also.slns;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 371865 on 3/18/2017.
 * find number divisible by 8
 */
public class NumberDivisble {
    public static void main(String[] args){
        int arr[] = {1,6,4,0,0};
        Set<String> results = findSubstrings(arr);
        for(String s : results){
            System.out.println(s);
        }
    }
    private static Set<String> findSubstrings(int[] arr){
        Set<String> result = new TreeSet<>();

        for(int i=0; i < arr.length-2; i++){
            int number = arr[i];
            int number1 = arr[i+1];
            int number2 = arr[i+2];
            if(number1%8==0){
                result.add(number1+"");
            }
            if(number2%8==0){
                result.add(number2+"");
            }
            if(number%8==0) {
                result.add(String.valueOf(number));
            }
            int twoDigit=Integer.valueOf(number+""+number1);
            if(twoDigit%8==0){
                result.add(String.valueOf(twoDigit));
            }
            int threeDigit= Integer.valueOf(twoDigit+""+number2);
            if(threeDigit%8==0){
                result.add(String.valueOf(threeDigit));
                String prevNumber=String.valueOf(threeDigit);
                for(int j=i-1;j>=0;j--){
                     if(arr[j]!=0){
                        prevNumber = arr[j]+prevNumber;
                         if(prevNumber.length()!=arr.length)
                        result.add(prevNumber);
                    }
                }
            }

        }

        return result;

    }
}
