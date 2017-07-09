package also.slns;

import java.util.*;

/**
 * Created by hpal(mehimu@gmail.com) on 3/13/2017.
 */
public class SumOfContiguousElements {
    public static void main(String[] args){

        int[] array = {5,3,34,30,9};

        //Arrays.sort(array,Collections.reverseOrder());
        System.out.println(largestNumber(array));

        System.out.println(Arrays.toString(array));


        int[] arr = {2, 3, 4, 11, 2, 1, 5, 3};
        int[] arr1 = {2, 3, -4, 3, 8, 7,-4};
        int[] arr2 = {-120, -202, -293, -60, -261, -67, 10, 82, -334, -393, -428, -182, -138, -167, -465, -347, -39, -51, -61, -491, -216, -36, -281, -361, -271, -368, -122, -114, -53, -488, -327, -182, -221, -381, -431, -161, -59, -494, -406, -298, -268, -425, -88, -320, -371, -5, 36, 89, -194, -140, -278, -65, -38, -144, -407, -235, -426, -219, 62, -299, 1, -454, -247, -146, 24, 2, -59, -389, -77, -19, -311, 18, -442, -186, -334, 41, -84, 21, -100, 65, -491, 94, -346, -412, -371, 89, -56, -365, -249, -454, -226, -473, 91, -412, -30, -248, -36, -95, -395, -74, -432, 47, -259, -474, -409, -429, -215, -102, -63, 80, 65, 63, -452, -462, -449, 87, -319, -156, -82, 30, -102, 68, -472, -463, -212, -267, -302, -471, -245, -165, 43, -288, -379, -243, 35, -288, 62, 23, -444, -91, -24, -110, -28, -305, -81, -169, -348, -184, 79, -262, 13, -459, -345, 70, -24, -343, -308, -123, -310, -239, 83, -127, -482, -179, -11, -60, 35, -107, -389, -427, -210, -238, -184, 90, -211, -250, -147, -272, 43, -99, 87, -267, -270, -432, -272, -26, -327, -409, -353, -475, -210, -14, -145, -164, -300, -327, -138, -408, -421, -26, -375, -263, 7, -201, -22, -402, -241, 67, -334, -452, -367, -284, -95, -122, -444, -456, -152, 25, 21, 61, -320, -87, 98, 16, -124, -299, -415, -273, -200, -146, -437, -457, 75, 84, -233, -54, -292, -319, -99, -28, -97, -435, -479, -255, -234, -447, -157, 82, -450, 86, -478, -58, 9, -500, -87, 29, -286, -378, -466, 88, -366, -425, -38, -134, -184, 32, -13, -263, -371, -246, 33, -41, -192, -14, -311, -478, -374, -186, -353, -334, -265, -169, -418, 63, 77, 77, -197, -211, -276, -190, -68, -184, -185, -235, -31, -465, -297, -277, -456, -181, -219, -329, 40, -341, -476, 28, -313, -78, -165, -310, -496, -450, -318, -483, -22, -84, 83, -185, -140, -62, -114, -141, -189, -395, -63, -359, 26, -318, 86, -449, -419, -2, 81, -326, -339, -56, -123, 10, -463, 41, -458, -409, -314, -125, -495, -256, -388, 75, 40, -37, -449, -485, -487, -376, -262, 57, -321, -364, -246, -330, -36, -473, -482, -94, -63, -414, -159, -200, -13, -405, -268, -455, -293, -298, -416, -222, -207, -473, -377, -167, 56, -488, -447, -206, -215, -176, 76, -304, -163, -28, -210, -18, -484, 45, 10, 79, -441, -197, -16, -145, -422, -124, 79, -464, -60, -214, -457, -400, -36, 47, 8, -151, -489, -327, 85, -297, -395, -258, -31, -56, -500, -61, -18, -474, -426, -162, -79, 25, -361, -88, -241, -225, -367, -440, -200, 38, -248, -429, -284, -23, 19, -220, -105, -81, -269, -488, -204, -28, -138, 39, -389, 40, -263, -297, -400, -158, -310, -270, -107, -336, -164, 36, 11, -192, -359, -136, -230, -410, -66, 67, -396, -146, -158, -264, -13, -15, -425, 58, -25, -241, 85, -82, -49, -150, -37, -493, -284, -107, 93, -183, -60, -261, -310, -380};

        int[] arr3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = contiguousSum(arr3);
        System.out.println(contiguousSum2(arr3));
        System.out.println(sum);
        int sum1 = contiSum(arr2);
        System.out.println(sum1);
        int nonContiSum = nonContiSum(arr1);
        System.out.println(nonContiSum);
        System.out.println(findMaxSumNonContig(arr1,arr1.length));
        System.out.println(findMax2(arr1));


        System.out.println(lengthOfLastWord(""));
    }

    private static int contiguousSum(int[] arr){
        int max_so_far = arr[0];
        int curr_max= arr[0];
        int start=0;
        int end = 0;
        int s =0;
        for(int i=1; i < arr.length; i++){
            curr_max = curr_max+arr[i];
            if(curr_max < 0) {
                curr_max = arr[i];
                s=i;
            }
            if(curr_max >= max_so_far){
                max_so_far = curr_max;
                start=s;
                end =i;
            }

            //curr_max = Math.max(arr[i],curr_max+arr[i]);
            //max_so_far = Math.max(curr_max,max_so_far);
        }
        System.out.println("Start - END" + start +"-"+end);
        return max_so_far;
    }

    private static int contiguousSum2(int[] arr){
        int curr_max = arr[0];
        int start = 0;
        int end = 0;
        int max_so_far = arr[0];
        for(int i=1; i < arr.length ; i++) {
            curr_max = curr_max+arr[i];
             if(curr_max < arr[i]){
                curr_max = arr[i];
                if(curr_max>0) {start = i;}
             }
                    //Math.max(arr[i], curr_max+arr[i]);
            if(curr_max >= max_so_far){
                max_so_far = curr_max;
                if(curr_max < 0) start=i;
                end=i;
            }

                    //Math.max(curr_max,max_so_far);
        }
        System.out.println("Start - END" + start +"-"+end);

        return max_so_far;
    }

    private static int contiSum(int[] arr){
        int cur_max = arr[0];
        int max_sum= arr[0];
        for(int i=1; i<arr.length; i++){
            cur_max = Math.max(cur_max,cur_max+arr[i]);
            max_sum = Math.max(cur_max,max_sum);
        }
        return max_sum;
    }
    private static int nonContiSum(int[] arr){
        int[] result = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            if(i==0) {
                result[0] = arr[0];
            }else if(i==1) {
                result[1] = Math.max(result[0],arr[1]);
            }else{
                result[i] = Math.max(result[i-2]+arr[i],result[i-1]);
            }
        }
        return result[arr.length-1];
    }

    static int findMaxSumNonContig(int arr[], int n)
    {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++)
        {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }
private static int findMax2(int[] arr) {
    int[] dp = new int[2];
    dp[0]=arr[0];
    dp[1]=arr[1];
    for (int i = 2; i < arr.length; i++) {
        int temp = dp[1];
        dp[1] = dp[0] + arr[i];
        dp[0] = Math.max(dp[0], temp);
    }
    return Math.max(dp[0],dp[1]);
}

    public static String largestNumber(int[] a) {
        String[] strArray = new String[a.length];
       // Map<Integer,String> map = new TreeMap<Integer,String>(Collections.reverseOrder());
        for(int i=0; i < a.length; i++){
            strArray[i]=String.valueOf(a[i]);
        }
        Arrays.sort(strArray, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return (t1+s).compareTo(s+t1);
            }
        });

        StringBuilder sbd = new StringBuilder();
        for(String s : strArray){
            sbd.append(s);
        }
        return sbd.toString();
    }

    public static int lengthOfLastWord(String s) {
        if(s==null || s.length()==0) return 0;
        int len=0;

        int j=s.length()-1;
       /* char c=s.charAt(j);
        while(c!=' '){
            len++;
            if(j==0) break;
            c=s.charAt(--j);
        }*/
        while(s.charAt(j)==' ' && j>=0){
            j--;
        }
        while(j>=0 && s.charAt(j) !=' ' ){
            len++;
            j--;
        }
        return len;
    }

}
