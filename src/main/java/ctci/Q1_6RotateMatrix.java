package ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by 371865 on 3/11/2017.
 */
public class Q1_6RotateMatrix {
    public static void main(String[] args){
       /* int[][] matrix = randomMatrix(4,4,1,9);
        printMatrix(matrix);
        //transpose(matrix);
       //int[][] result =  rotateArray(matrix);
        System.out.println("---------------------");
        rotateInPlaceAntiClockWise(matrix);

        printMatrix(matrix);

        System.out.println("---------------------");
        spiralPrinting(matrix);
        /*rotateInPlaceClockWise(matrix);
        printMatrix(matrix);
        rotate(matrix,4);
        System.out.println("---------------------");
        printMatrix(matrix);*/
        /*setZeros(matrix);
        System.out.println("---------------------");
        printMatrix(matrix);*/
        /*System.out.println("---------------------");
        System.out.println();

        System.out.println(generateMatrix(21));*/
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(list);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(5);
        list1.add(6);

        input.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(7);
        list2.add(8);
        list2.add(9);

        input.add(list2);
        rotate(input);
        System.out.println("****************");
        System.out.println();
        System.out.println(input);


    }
    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }
    ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }

    public static void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; ++i) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    System.out.print(" ");
                }
                if (matrix[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void setZeros(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length ; j++){
                if(matrix[i][j]==0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                if(row[i] || column[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }

   /* private static void rotateOwn(int[][] matrix, int n){
        for(int row =0; row < n/2; row++){
            int startIdx = row;
            int endIdx = n-1-row;
            for(int i=startIdx; i < endIdx;i++ ){
                int offset = i - startIdx;
                //save top
                int top = matrix[row][startIdx];
                //left to top
                matrix[row][startIdx] = matrix[endIdx][endIdx-offset];
                //top to right
                matrix[endIdx][endIdx-offset] = matrix[endIdx][]

            }
        }
    }*/

    private static int[][] rotateArray(int[][] matrix){
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i=0; i < matrix.length; i++ ){
            for(int j=0; j < matrix[0].length; j++){
                result[i][j] = matrix[matrix.length-1-j][i];
            }
        }
        return result;
    }

    private static void rotateInPlaceClockWise(int[][] matrix){
        //transpose
        transpose(matrix);
        //reverse rows
        for(int i=0; i < matrix.length; i++){
            reverse(matrix[i]);
        }

    }

    private static void rotateInPlaceAntiClockWise(int[][] matrix){
        transpose(matrix);
        reverseColumn(matrix);
        /*//reverse each row
        for(int i=0; i < matrix.length; i++){
            reverse(matrix[i]);
        }
        //transpose
        transpose(matrix);*/
    }

    private static void transpose(int[][] matrix){
        for(int i=0; i < matrix.length; i++){
            for(int j=i; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    private static int[] reverse(int[] arr){
        for(int i=0,j=arr.length-1; i<=j; i++,j--){
            swap(arr,i,j);
        }
        return arr;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]=temp;
    }

    private static void reverseColumn(int[][] matrix){
        for(int j=0; j < matrix[0].length; j ++){
            for(int i=0,k=matrix.length-1; i<=k; k--,i++){
                //swap(matrix);
                int temp = matrix[i][j];
                matrix[i][j]=matrix[k][j];
                matrix[k][j]=temp;
            }
        }
    }

    private static void spiralPrinting(int[][] matrix){
        int m = matrix.length;
        int n= matrix[0].length;
        int row=0,col=0;
        while(m > 0 && n > 0){

            //print top
            for(int i=0; i < n-1; i++){
                System.out.print(matrix[row][col++]+" ");
            }
            //print right
            for(int i=0; i < m-1; i++){
                System.out.print(matrix[row++][col]+" ");
            }
            //print bottom
            for(int i=0; i < n-1;i++){
                System.out.print(matrix[row][col--]+"  ");
            }
            //print left
            for(int i=0; i< n-1; i++){
                System.out.print(matrix[row--][col]+"  ");
            }
            row++;
            col++;
            m=m-2;
            n=n-2;
        }
    }

    public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>(a);
        for(int i=0; i < a ; i++){
            ArrayList<Integer> row = new ArrayList<Integer>(a);
            for(int j=0; j < a ; j++){
                row.add(0);
            }
            output.add(i,row);
        }
        int row=0,col=0;
        int counter=1;
        int n=a;
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

    public static void rotate(ArrayList<ArrayList<Integer>> a) {


        for(int i=0; i <a.size(); i++){

            for(int j=i; j < a.size(); j++){
                    Integer temp = a.get(i).get(j);
                    Integer temp1 = a.get(j).get(i);
                    a.get(j).add(i, temp);
                    a.get(i).add(j, temp1);
                    a.get(i).remove(j+1);
                    a.get(j).remove(i+1);
            }
        }

        for(int i=0; i < a.size(); i++){
            ArrayList<Integer> list = a.get(i);
            Integer[] reverse = new Integer[a.size()];
            list.toArray(reverse);
            for(int j=0,k=list.size()-1; j<k; j++,k--){
                int temp = reverse[j];
                reverse[j] = reverse[k];
                reverse[k]=temp;
            }
            list.clear();
            list.addAll(Arrays.asList(reverse));
        }
    }
}
