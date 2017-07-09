package also.slns;

import java.util.Arrays;

/**
 * Created by Himadri Pal (mehimu@gmail.com) on 6/16/2017.
 *  Print all primes less than N
 */
public class FindAllPrimeLessThanN {
    public static void main(String[] args){
        int n=100;
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes,true);
        for(int p=2; p*p <= n ; p++){
            if(primes[p]){
                for(int i=2*p; i <= n ; i=i+p){
                    primes[i]=false;
                }
            }
        }

        for(int i=1; i < n ; i++){
            if(primes[i]){
                System.out.println(i);
            }
        }
    }
}
