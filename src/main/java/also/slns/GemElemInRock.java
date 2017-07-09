package also.slns;

import java.util.Scanner;

/**
 * Created by 371865 on 12/14/2016.
 */
public class GemElemInRock {

    public static void main(String[] args) {
        GemElemInRock s = new GemElemInRock();

        int[] elem = new int[26];
        int gemCount=0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0; i < n ;i++){
            String rock = in.next();
            char[] chars = new char[26];
            for(int j=0;j<rock.length();j++){
                char element = rock.charAt(j);
                //hold the presence count of the element : increase count by one per rock if present
                int countOfElem = elem[element - 'a'];
                //cehck if the letter is already been looped through..then skip the rest of the parts
                // to keep count of distinct characters.
                if(chars[element -'a']== element){
                    continue;
                }else {
                    //hold the character visited to check if it doesn't get visited twice in a rock.
                    chars[element - 'a'] = element;
                    //increase count by one per rock if present
                    countOfElem = countOfElem + 1;
                    elem[element - 'a'] = countOfElem;
                }
                // check if it matches the no of rock to be eligible to become gem
                if(countOfElem == n){
                    gemCount=gemCount+1;
                }
            }
        }
        System.out.println(gemCount);
    }
}
