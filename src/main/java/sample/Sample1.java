package sample;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Hpal on 5/4/2017.
 */
public class Sample1 {

    public static void main(String[] arr){
        System.out.println(fibonacci(7));
        System.out.println(fibonacciDP(7));
        System.out.println(mySqrt(2147395599));
    }

    public static int fibonacci(int n){
        if(n <=2) return 1;
        return fibonacci(n-1)+fibonacci(n-2);

    }
    public static int fibonacciDP(int n){
        int[] fib = new int[n+1];
        for(int i=0; i <= n; i++){
            if(i <=2){
                fib[i]=1;
            }else{
                fib[i]=fib[i-2]+fib[i-1];
            }
        }
        return fib[n];

    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int a) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>(a);
        for(int i=0; i < a ; i++){
            ArrayList<Integer> row = new ArrayList<Integer>(a);
            for(int j=0; j < a ; j++){
                row.add(1);
            }
            output.add(row);
        }
        int row=0,col=0;
        int counter=1;
        int n=a;
        if(n <=1) return output;
        while(n > 0){
            //traverse left to right
            for(int i=0; i < n-1 ; i++){
                output.get(row).remove(col);
                output.get(row).add(col++,counter++);
            }
            //traverse top to bottom
            for(int i=0; i < n-1 ; i++){
                output.get(row).remove(col);
                output.get(row++).add(col,counter++);
            }
            //traverse right to left
            for(int i=0; i < n-1 ; i++){
                output.get(row).remove(col);
                output.get(row).add(col--,counter++);
            }
            //traver bottom to up
            for(int i=0; i < n-1 ; i++){
                output.get(row).remove(col);
                output.get(row--).add(col,counter++);
            }
            n=n-2;

            row=row+1;
            col=col+1;
            if(n==1){
                output.get(row).remove(col);
                output.get(row).add(col,counter);
            }

        }

        return output;
    }

    public static int mySqrt(int x) {
        // Base Cases
        if (x == 0 || x == 1)
            return x;

        int start = 0, end = x/2, ans=0;
        while (start <= end)
        {
            int mid = (start + end)/2;

            if (mid*mid == x)
                return mid;


            if (mid*mid < x)
            {
                start = mid + 1;
                ans = mid;
            }
            else
                end = mid - 1;
        }
        return ans;
    }
}
