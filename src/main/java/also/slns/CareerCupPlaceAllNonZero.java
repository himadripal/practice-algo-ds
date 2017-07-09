package also.slns;

/**
 * Created by hpal(mehimu@gmail.com) on 3/16/2017.
 */
public class CareerCupPlaceAllNonZero {
    public static void main(String[] args){
        int arr[] ={4,-1,-2,0,-3,-2,0,-7};
        /*for(int i=0; i < arr.length; i++){
            if(arr[i] <= 0){
                swap(arr,i,0);
            }
        }*/
        System.out.println((sortOnNonZero(arr,0,arr.length)+1));

    }



    private static int sortOnNonZero(int[] arr, int lo, int hi){
        int j = partition(arr,lo,hi);
        //sortOnNonZero(arr,lo,j-1);
        //sortOnNonZero(arr,j+1,hi);
        return j;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int partition(int[] arr, int lo, int hi){
        int i=lo-1;
        int j=hi;
        while(lo <=hi){
            while(arr[++i] > 0){
                if(i==hi) break;
            }
            while(arr[--j] <= 0){
                if(j==lo) break;
            }
            if(i>=j) break;
            swap(arr,i,j);
        }
        return j;
    }
}
