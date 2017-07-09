package also.slns;

import java.util.HashMap;

/**
 * Created by hpal(mehimu@gmail.com) on 3/12/2017.
 *
 * 1. Find KBiggesNumber using quickSelect - modified quicksort algorithm
 * Partition - then check if partition index is less or greater than k
 * adjust the start and end accordingly for next partition call - in a loop
 *  time complexity is said to be O(n) - considering reducing amount of work every iteration.
 *  for easier calculation - if we consider amount of work gets halved every iteration
 *  N+N/2+N/4+N/8 ... logN times = N+ (1/2+1/4+1/8 .... logN times) = N+ ~1*N= 2N ~ O(N).
 *
 * 2. fibonacci with DP and recursion
 */
public class FindKBiggestNumber {
    public static void main(String[] args){
        int[] arr = {9,4,5,8,3,6,2,7,1,0};
        int k =7;
        //System.out.println(Quick.select(arr,7));
        System.out.println(quickSelect(arr,1));
        long t1 = System.currentTimeMillis();
        System.out.println("fibonacciDP of : "+fibonachhiDP(40)+" in -"+(System.currentTimeMillis()-t1));
        System.out.println("fiboNacDPWithRecursion of :"+ fiboNacDPWithRecursion(40)+" in -"+(System.currentTimeMillis()-t1));
        System.out.println("fibonacci of : "+findFibonacci(100)+" in -"+(System.currentTimeMillis()-t1));
    }

    private static void quickSort(int[] arr){

    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * call partition in a loop until partitionIndex is same as k
     * based on partitionIndex - adjust start and end position of partition call
     * @param arr
     * @param k
     * @return
     */
    private static int quickSelect(int[] arr, int k){
        int start = 0;
        int end = arr.length-1;
        while(end > start){
            int partitionIdx = partition(arr,start,end);
            // if k is less than parition index - then k is on the beginning
            // end partionIndex -1
            if(partitionIdx > k){
                end = partitionIdx - 1;
             // if k is less than parition index - then k is on the beginning
             // start= partionIndex +1
            }else if(partitionIdx < k) {
                start = partitionIdx+1;
            }else return arr[k];
        }
        return arr[k];
    }
   // int[] arr = {9,4,5,8,3,6,2,1};

    private static int partition(int[] arr,int start, int end) {
            int i=start, j=end+1;
            int pivotElem = arr[start];
            while (true){
                while(arr[++i] > pivotElem){
                    if(i==arr.length-1) break;
                }
                while(arr[--j] < pivotElem){
                   if(j==0) break;
                }
                if(i>=j ) break;
                swap(arr,i,j);
            }
            swap(arr,start,j);
        return j;
    }

    private static int findFibonacci(int n){
        if(n <=2){
            return 1;
        }else{
            return findFibonacci(n-1)+findFibonacci(n-2);
        }
    }

    /**
     * fibonacci in DP
     * @param n
     * @return
     */
    private static int fibonachhiDP(int n){
        int[] fibonacci = new int[n+1];
        for(int i=0; i < n+1 ; i++) {
            if (i <= 2) {
                fibonacci[i] = 1;
            } else {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }
        }
        return fibonacci[n];
    }
    static HashMap<Integer,Integer> fibTable = new HashMap<>();

    /**
     * Recursion with DP - store the result and
     * check if the result is calculated before
     * skip the method call
     *
     * @param n
     * @return
     */
    private static int fiboNacDPWithRecursion(int n){
        if(n<=2){
            fibTable.put(n,1);
            return 1;
        }else {
            int f1=0;
            int f2=0;
            int f=0;
            // get call is O(n)
            if (fibTable.get(n-1)==null && fibTable.get(n-2)==null) {
                f1= fibTable.get(n-1);
                f2 = fibTable.get(n-2);
                f=f1+f2;
                fibTable.put(n,f);
                return f;
            }else return fiboNacDPWithRecursion(n-1)+fiboNacDPWithRecursion(n-2);
        }
    }


}
