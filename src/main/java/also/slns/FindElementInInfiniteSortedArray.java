package also.slns;

/**
 * Created by hpal(mehimu@gmail.com) on 12/21/2016.
 * Find an element in infinite length sorted array
 * Idea is to use binary search - first determine lo and hi for binary search
 */
public class FindElementInInfiniteSortedArray {
    int[] arr = null;
    public FindElementInInfiniteSortedArray(int n){
        arr = new int[n];
        for(int i=0 ; i < n; i++){
            arr[i] = i+5;
        }
    }
    public static void main(String[] args){

        FindElementInInfiniteSortedArray binarySearch = new FindElementInInfiniteSortedArray(1000);
        //determine the lo and hi
        //start with 0 as lo and 1 as hi
        int l=0,r=1,key =10;
        //if the key is greater - increase the range from r to 2r
        while(binarySearch.arr[r] < key ){
            l=r;
            r = 2* r;
        }
        int position = binarySearch.binarySearch(l,r,key);
        System.out.println(position);

        int[] arr = {1,2,3,4,6,7,5,0};
        int [] arr1 = {1, 2, 3, 2, 5};

        System.out.println(binarySearch.isDuplicatePresent(arr1));

        int peakPosition = binarySearch.findPeak(0,arr.length-1,arr);
        System.out.println("peakPosition - "+peakPosition+",element - "+ (peakPosition>0 ? arr[peakPosition]:peakPosition));
    }

    /**
     * Binary Search
     * @param l
     * @param r
     * @param key
     * @return
     */
    int binarySearch(int l,int r, int key){
        while(r >= l){
            int mid = l + (r -l)/2; // to keep the mid in int range (r-l)/2
            if(arr[mid] == key){
                return mid;
            }else if( arr[mid] > key){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return arr.length-1;
    }

    /**
     * Find a peak if exists
     * example 1,2,4,6,7,5,3
     * 7 is the peak position
     * @param l
     * @param r
     * @param arr
     * @return
     */
    int findPeak(int l,int r,int[] arr){
        while(r >= l){
            int mid = l + (r -l)/2;
            // when both r and l are same that is peak position
            if(r==l){
                return r;
            }else if( arr[mid] > arr[mid+1]){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }

    /**
     * Find if there is a duplicate in an array with all integers < arr.length
     * logic - sum up all integers from 1 to n and also sum up all elements in the array
     * if both sums are not same - then duplicate present.
     * Example input arr - 1,2,2,3,4
     * @param arr
     * @return
     */
    boolean isDuplicatePresent(int [] arr){
        int simpleSum = 0;
        int sumOfElements = 0;
        for(int i=0; i < arr.length; i++){
            //sum up 1 to n
            simpleSum+= (i+1);
            //sum up all elements in the array
            sumOfElements +=arr[i];
        }
        return (simpleSum!=sumOfElements);
    }
}
