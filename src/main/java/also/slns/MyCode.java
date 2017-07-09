package also.slns;

import java.io.*;

class MyCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Hello Java");
        int[] arr = { 1,3,5,7,9,10};
        int key = 11;
        int result = binarySearch(arr,key);
        System.out.println("Found :"+(result> 0?arr[result]:key) +" at index :"+ result);
    }

    public static int binarySearch(int[] arr,int key){
        int lo = 0, hi = arr.length-1;

        while(lo <= hi){
            int mid = lo + (hi -lo)/2;
            if(key == arr[mid]) {
                return mid;
            }
            if(key > arr[mid]){
                lo = mid+1;
            }else{
                hi = mid -1;
            }
        }
        return -1;
    }
}