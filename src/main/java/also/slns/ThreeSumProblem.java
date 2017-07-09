package also.slns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hpal on 3/14/2017.
 */
public class ThreeSumProblem {
    public static void main(String[] args){
        int[] arr = {-25, -10, -7, -3, 2, 4, 8, 10};
        int[] arr1 = {-1, 0, 1, 2, -1, -4};
       // threeSum(arr1,0);
        System.out.println("threesum - "+threeSum1(arr1));
        //List<List<Integer>> result = threeSum(arr1);
        //System.out.println(result.toString());

    }

    private static void threeSum(int[] arr,int sum){
        for(int i=0; i<arr.length-3; i++){
            int a =arr[i];
            int j=i+1;
            int k = arr.length-1;
            while(j<k){
                int b=arr[j];
                int c=arr[k];
                if(a+b+c==sum){
                    System.out.println(a+","+b+","+c);
                    j++;k--;
                }else if(a+b+c > sum){
                    k=k-1;
                }else{
                    j=j+1;
                }
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        for(int i=0; i<arr.length-3; i++){
            int a =arr[i];
            int j=i+1;
            int k = arr.length-1;
            while(j<k){
                int b=arr[j];
                int c=arr[k];
                if(a+b+c==0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(a);
                    list.add(b);
                    list.add(c);

                    result.add(list);

                    System.out.println(a+","+b+","+c);
                    j++;k--;
                }else if(a+b+c > 0){
                    k=k-1;
                }else{
                    j=j+1;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> output = new LinkedList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            int a = nums[i];
            int j = i + 1, k = nums.length - 1;
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            while (j < k) {
                int b = nums[j];
                int c = nums[k];

                if (a + b + c == 0) {
                    List<Integer> combo = new ArrayList<>();
                    combo.add(a);
                    combo.add(b);
                    combo.add(c);
                    output.add(combo);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (a + b + c < 0) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        return output;
    }
}
