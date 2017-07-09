package also.slns;

/**
 * Created by hpal(mehimu@gmail.com) on 3/12/2017.
 *
 * Given an array - find largest possible rectangle
 * Assuming array elements are plotted as Y axis value
 */
public class FindLargestPossibleRect {
    public static void main(String[] args){
        int[] arr ={2,1,5,6,3,3};
        int area = Integer.MIN_VALUE;

        System.out.println(findArea(arr));
    }
    public static int findArea(int[] arr ) {
        int maxArea=0;
        int loop=0;
        while(loop < arr.length) {
            int i = loop;
            int j = loop;
            while (i < arr.length - 1 && arr[i+1] >= arr[loop]) {
                i++;
            }
            while (j > 0 && arr[j-1] >= arr[loop]) {
                j--;
            }
            System.out.println(i+","+j+","+arr[loop]);
            int width = (i-j)==0?1:(i-j);
            int area = width*arr[loop];
            maxArea=(area>maxArea?area:maxArea);
            loop++;
        }
        //int width = (i-j);
        return maxArea;
    }

}
