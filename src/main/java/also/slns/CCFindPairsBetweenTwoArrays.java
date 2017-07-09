package also.slns;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by hpal(mehimu@gmail.com) on 3/16/2017.
 */
public class CCFindPairsBetweenTwoArrays {

    public static void main(String[] args){
        int[] arr1 = {1,2,4,-6,5,7,9};
        int[] arr2 = {3,6,3,4,0};
        sort(arr1,0,arr1.length-1);
        sort(arr2,0,arr2.length-1);
        Set<String> pairs = findPairs(arr1,arr2,5);
        for(String s : pairs){
            System.out.println(s);
        }
        printArray(arr1);
        printArray(arr2);


    }
    private static void printArray(int[] arr){
        System.out.println("----");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("----");
    }
    private static void sort(int[] arr, int lo, int hi){
        if(hi<=lo) return;
        int j = partition(arr,lo,hi);
        sort(arr,lo,j-1);
        sort(arr,j+1,hi);
    }

    private static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int partition2(int[] arr,int lo,int hi){
        int i=lo,j=hi+1;
        while (true){
            while(arr[++i] < arr[lo]){
                if(i==hi){
                    break;
                }
            }
            while(arr[lo] < arr[--j]){
                if(j==lo){
                    break;
                }
            }
            if(i>=j) break;
            swap(arr,i,j);
        }
        swap(arr,lo,j);
        return j;
    }
    private static int partition(int[] arr, int lo, int hi){
        int i=lo;
        int j=hi+1 ;
        while(lo <=hi){
            while(arr[++i] < arr[lo]){
                if(i==hi) break;
            }
            while(arr[lo] < arr[--j]){
                if(j==lo) break;
            }
            if(i>=j) break;
            swap(arr,i,j);
        }
        swap(arr,lo,j);
        return j;
    }
    private static Set<String> findPairs(int[] arr1, int[] arr2,int sum) {
        int i=0, j = arr2.length-1;
        Set<String> pairs = new TreeSet<>();
        while(i < arr1.length && j >= 0){
            int iVal=arr1[i];
            int jVal=arr2[j];
            int localSum = iVal+jVal;
            if(localSum==sum){
                pairs.add(arr1[i]+","+arr2[j]);
                i++; j--;
                //continue;
            }else if(localSum > sum){
                j--;
                if(j < 0 && i < arr1.length){
                    j=arr2.length-1;
                }
            }else if(localSum < sum){
                i++;
                if(i > arr1.length && j>0){
                    i=0;
                }
            }



        }
        return pairs;
    }
}
