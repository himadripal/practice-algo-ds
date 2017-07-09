package also.slns;

/**
 * Created by 371865 on 3/12/2017.
 */
public class MergeTwoSortedArrays {
    public static void main(String[] args){
        int[] a = {1,3,5,7,9,0,0,0,0};
        int[] b=  {2,4,6,8};
        merge(a,b,5);
        System.out.println();
        for(int i=0; i < a.length; i++){
            System.out.print(a[i]);
        }
    }

    private static void merge(int[] a, int[] b, int countA) {
        int i = countA-1;
        int j = b.length-1;
        int k = countA + b.length-1;
        while(i>=0 && j>=0){
            if(a[i]>b[j]){
                a[k--] = a[i--];
            }else{
                a[k--] = b[j--];
            }
        }
        while(j>=0){
            a[k--] = b[j--];
        }
    }
}
