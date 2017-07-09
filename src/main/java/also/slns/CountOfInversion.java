package also.slns;

import java.util.Scanner;

/**
 *  Find number of inversion in an array
 *  inversion is when how many bigger elements appear before smaller elements
 */
public class CountOfInversion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long invCount = mergeSort(arr,new int[n],0,n-1);
            System.out.println(invCount);
        }

    }

    public static long mergeSort(int[] arr,int[] aux, int lo, int hi){
        long invCount = 0;
        if(hi <= lo){
            return invCount;
        }
        int mid = lo + (hi-lo)/2;
        invCount = mergeSort(arr,aux,lo,mid);
        invCount += mergeSort(arr,aux,mid+1,hi);
        invCount += merge(arr,aux,lo,mid+1,hi);
        return invCount;
    }

    /**
     *  merge method of merge sort
     * @param arr
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     * @return
     */
    public static long merge(int[] arr, int[] aux,int lo, int mid, int hi){
        long invCount =0;

        int i=lo;
        int j=mid;
        int k=lo;
        while( (i <=mid-1) && (j <= hi)){
            if(arr[i] <= arr[j]){
                aux[k++]=arr[i++];
            }else{ // arr[i] > arr[j] =>
                // all elements from i to mid are bigger
                aux[k++] = arr[j++];
                invCount=invCount+(mid-i);
            }
        }
        /* remaining elements of left subarray aux*/
        while (i <= mid-1)
            aux[k++] = arr[i++];

          /* remaining elements of right subarray to aux */
        while (j <= hi)
            aux[k++] = arr[j++];

        /*merged elements to original array*/
        for (i=lo; i <= hi; i++)
            arr[i] = aux[i];
        return invCount;
    }
}
