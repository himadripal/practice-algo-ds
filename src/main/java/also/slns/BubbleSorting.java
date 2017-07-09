package also.slns;

import java.text.MessageFormat;
import java.util.Scanner;

/**
 *  Bubble sort - calculate no of swaps..
 */
public class BubbleSorting {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0; i < n ; i ++){
            arr[i] = in.nextInt();
        }
        System.out.println(MessageFormat.format("Array is sorted in {0} swaps.",bubbleSort(arr)));
        System.out.println(MessageFormat.format("First Element: {0}",arr[0]));
        System.out.println(MessageFormat.format("Last Element: {0}",arr[n-1]));


    }
    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0 ;
    }
    private static void swap(Comparable[] a,int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public static int bubbleSort(Comparable[] arr){
        int n = arr.length;
        int totalSwaps=0;
        for(int i=0; i < n; i++){
            int swapInOnePass =0;
            for(int j=0; j < n-1; j++){
                if(less(arr[j+1],arr[j])){
                    swap(arr,j,j+1);
                    swapInOnePass++;

                }
            }
            n--;
            if(swapInOnePass==0){
                break;
            }else {
                totalSwaps+=swapInOnePass;
            }
        }
        return totalSwaps;
    }
}