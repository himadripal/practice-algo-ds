package also.slns;

/**
 * Created by 371865 on 3/19/2017.
 */
public class RotateAnArray {
    public static void main(String[] args){
        int[] arr = {2,3,4,5,6,7};
        rotateClockwise(arr,4);

        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        rotateAntiClockWise(arr,4);
        System.out.println("--------");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    private static void rotateClockwise(int[] arr,int n){
        reverse(arr,0,arr.length-n-1);
        reverse(arr,arr.length-n,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    private static void rotateAntiClockWise(int[] arr, int n){
        reverse(arr,0,n-1);
        reverse(arr,n,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    private static void reverse(int[] arr,int start, int end){
        for(int i=start,j=end; i<=j; i++,j--){
            swap(arr,i,j);
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }
}
