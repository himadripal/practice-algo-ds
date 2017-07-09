package also.slns;

import java.util.*;

public class DPCoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       // int n = in.nextInt();
       // int m = in.nextInt();
        int coins[] = {1,2,3,5,7};
        /*for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }*/
        long t1=System.currentTimeMillis();
        long countRecursive = coinChangeRecursive(coins,100,0);//countDP(coins,m,n);
        System.out.println(countRecursive);
        System.out.println(countDP(coins,5,100));
       /* System.out.println(fiboNacci(3));
        System.out.println(fiboNacci(4));
        System.out.println(fiboNacci(5));
        System.out.println(fiboNacci(6));
        System.out.println(fiboNacci(7));
        System.out.println(fiboNacci(8));

        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
        System.out.println(factorial(6));
        System.out.println(factorial(7));
        System.out.println(factorial(8));*/

    }

    public static long countDP(int[] coins, int m, int n){
        long[] countTable = new long[n+1];

        for(int i=0; i < countTable.length ; i++){
            countTable[i] = 0;
        }
        countTable[0] = 1;
        String combination = "";
        for(int i=0; i < m; i++){
           int coin = coins[i];
          //  System.out.println("coin - "+ coin);
            for(int j=coin; j <= n ; j++){
                //System.out.println("j ="+j+",coin =coins["+i+"]="+coin+"countTable[j-coin]="+countTable[j-coin]);
                long count = countTable[j-coin];
                countTable[j] = countTable[j]+count;
               //System.out.println("countTable["+sum+"] = "+countTable[sum]);
            }
        }
        return countTable[n];
    }

    public static long fiboNacci(int n){
        long[] fiboNacciTable = new long[n+1];
       // fiboNacciTable[0]=1;
        for(int i=0; i <= n; i++ ) {
            if (i <= 2) {
                fiboNacciTable[i]=1;
            } else {
                fiboNacciTable[i] = fiboNacciTable[i - 1] + fiboNacciTable[i - 2];
            }
        }
        return fiboNacciTable[n];
    }

    public static long factorial(int n){
        long[] facTable = new long[n+1];
        for(int i=0; i <= n; i++ ) {
            if (i == 0) {
                facTable[i]=1;
            } else {
                // long f = ;
                facTable[i] = facTable[i - 1] * i;
            }
        }
        return facTable[n];
    }

   private static List<String> combinations = new ArrayList<>();
   private static Map<String,Long> memoMap = new HashMap<>();
   public static long coinChangeRecursive(int [] arr, int money,int index){
       int amountWithCoins = 0 ;
       long ways =0;

       if(money == 0){
          return 1;
       }
       if(index >= arr.length){
           return 0;
       }
       if(memoMap.containsKey(money+"-"+index)) return memoMap.get(money+"-"+index);
       while(amountWithCoins <= money){
           int remaining = money - amountWithCoins;
           int coin = arr[index];
           //combo+=(coin+",");
           ways += coinChangeRecursive(arr,remaining,index+1);
           memoMap.put(money+"-"+index,ways);
           amountWithCoins+=coin;
       }
       return ways;
    }
}

