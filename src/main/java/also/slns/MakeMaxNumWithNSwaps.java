package also.slns;

/**
 * Created by hpal(mehimu@gmail.com) on 3/9/2017.
 *
 * Make maximum possible number with N swaps
 * algo -
 * 1. find the max digit,
 * 2. bubbleup using modified bubbleSort algorithm
 * 3. count no of swaps in each iteration and stop the loop when swap becomes 0
 * time complexity => O(nk) , if noOfSwaps=k, and n elements ->
 *
 * Another problem - find highest frequnency of a digit in an array
 *
 *
 */
public class MakeMaxNumWithNSwaps {

    public static void main(String[] args){



        int[] arr1 = {5,1,5,4};
        //make maximum number with n swaps
        //n=2;
        makeMaxNum(arr1,2);
        printArr(arr1);
        //this is another problem - find highest frequency number
        int[] arr = {3,2,2,5,5,5,4,2};
        System.out.println(highestFrequency(arr));
    }

    public static String highestFrequency(int[] arr){
        int[] digitArr = new int[10];
        for(int i=0; i < arr.length; i++){
            int digit = arr[i];
            digitArr[digit]=digitArr[digit]+1;
        }
        int maxFreq = 0;
        int maxFreqDigit = 0;
        for(int i=0; i<digitArr.length; i++){
            int freq = digitArr[i];
            if(freq > maxFreq){
                maxFreq = freq;
                maxFreqDigit = i;
            }
        }
        return  maxFreq+":"+maxFreqDigit;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /*public static void makeMaxNumWithNSwap(int[] arr, int swap){
        int noOfSwap = 0;
       for(int i=swap; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j-1] < arr[j]){
                    swap(arr,j-1,j);
                    if(++noOfSwap==swap){
                        return;
                    }
                }
            }
       }
    }*/

    public static void makeMaxNum(int[] arr, int swap){
        for(int i=0; (swap > 0 && i < arr.length) ;i++){
            int position = findMax(arr,i,swap);
            int noOfSwaps = bubbleToTop(arr,i,position);
            swap = swap-noOfSwaps;
        }
    }

    /**
     * find the max value in the range of number of swaps allowed
     * if you are allowed only 2 swaps,
     * then max should within a distance of 2 from current element
     *
     * @param arr
     * @param i
     * @param n
     * @return
     */
    private static int findMax(int[] arr,int i, int n){
        int max=0;
        int maxPosition =0;

        while(n > 0 && i < arr.length ) {
            int num = arr[i];
            if(num > max){
                max = num ;
                maxPosition = i;
            }
            //decrement n=no of swaps // important
            i++;n--;
        }
        return maxPosition;
    }

    /**
     * Bubble the max element to its final position
     * final position will always be < current position for greater value
     * Constraint is only one step swap at a time
     * @param arr
     * @param finalPosition
     * @param startPosition
     * @return
     */
    private static int bubbleToTop(int[] arr,int finalPosition, int startPosition){
        int noOfSwap = 0;
        for(int i=startPosition; i>finalPosition; i--){
            //constraint - one jump at a time
            swap(arr,i-1,i);
            noOfSwap++;
        }
        return noOfSwap;
    }

    private static void printArr(int[] arr){
        for(int i=0; i < arr.length;i++ ){
            System.out.print(arr[i]+" ");
        }
    }


}
