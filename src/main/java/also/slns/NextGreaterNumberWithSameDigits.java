package also.slns;

import java.util.Arrays;

/**
 * Created by 371865 on 3/10/2017.
 */
public class NextGreaterNumberWithSameDigits {
    public static void main(String[] args){
        int[] arr ={2,1,8,7,6,5};//{2,1,2,6,0};//{4,3,2,1};//{1,2,3,4} ;//{5,3,4,9,7,6};//;
        //start from right Most and find Position of the inversion (i-1)th
        int inversionPos = inversionPos(arr);
        if(inversionPos == -1){
            System.out.println("Not Possible");
            return;
        }
        //findMin starting from inversionPos+1 to n
        int minPos = findMinPos(arr,inversionPos+1,arr.length,arr[inversionPos]);
        swap(arr,inversionPos,minPos);
        //swap(minPos,inversionPos+1,arr)
        //sortAsc(inversionPos+1, n);
       // Arrays.sort(arr,inversionPos+1, arr.length);
        sortAsc(arr,inversionPos+1,arr.length);
        printArr(arr);
        int[] arr2 = {1,2,2,1,5,3};
        removeDuplicates(arr2);
        //printArr(arr2);
        System.out.println();
        //System.out.println(createSmallestNum("DIDI"));
    }
    private static void printArr(int[] arr){
        for(int i=0; i < arr.length;i++ ){
            System.out.print(arr[i]+" ");
        }
    }
    private static int inversionPos(int[] arr){
        int inversionP = -1;
        for(int i=arr.length-1; i > 1; i--){
            if(less(arr[i-1],arr[i])){
               inversionP = i-1;
               break;
            }
        }
        return inversionP;
    }
    private static int findMinPos(int[] arr,int start,int length,int smallest){
        int min = Integer.MAX_VALUE;
        int minPos = 0;
        for(int i=start; i < length; i++){
            if(less(arr[i],min) /*&& less(smallest,arr[i])*/){
                min = arr[i];
                minPos=i;
            }
        }
        return minPos;
    }

    private static boolean less(int i, int j){
        return i < j;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sortAsc(int[] arr, int start, int length){
        for(int i=start,j=length-1; j>=i; i++,j--){
            swap(arr,i,j);
        }
    }

    private static void removeDuplicates(int[] arr){

        System.out.println();
        for(int i=0; i < arr.length; i++) {
          if( arr[Math.abs(arr[i])] >= 0) {
               System.out.print(Math.abs(arr[i])+" ");
                arr[Math.abs(arr[i])] = - arr[Math.abs(arr[i])];
          }else{
              //System.out.print(Math.abs(arr[i])+" ");
          }

        }
    }

    /*private static String createSmallestNum(String charSeq){
        char prevChar = 'A';
        int count = 0;
        StringBuilder builder = new StringBuilder();
        int lastUsedNo = 0;
        int i=0;
        while(i < charSeq.length()) {
            int sameCount = 0;


        }
        return builder.toString();
    }*/


}
