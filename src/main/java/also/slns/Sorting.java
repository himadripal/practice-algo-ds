package also.slns;

import edu.princeton.cs.algs4.StdRandom;

import java.text.MessageFormat;
import java.util.Stack;

/**
 * Created by Himadri Pal on 1/22/2017.
 */
public class Sorting {
    public static void main(String[] args){

        Character[] arr = new Character[26];
        for(int i=0;i<26;i++){
           arr[i] = (char) (i+65);
           System.out.print(arr[i]+ " ");
        }
        arr[1]='A';
        //selectionSortTest(arr);
        //insertionSortTest(arr);
        //knuthShuffle(arr);
       /* System.out.println(isSorted(arr,0,arr.length-1));
        quickSortTest(arr);
        knuthShuffle(arr);
        bubbleSortTest(arr);
        System.out.println(isSorted(arr,0,arr.length-1));
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(8);
        stack.push(4);
        sortAStack(stack);*/
       int[] arr1 = {9,5,10,2};
        heapSort(arr1);
       /* printArray(arr1);
        System.out.println(maxDiff(arr1));
        Random random = new Random();
        for(int i=0; i< 4; i++)
        System.out.println(random.nextInt(4));*/
        mergeSortTest(arr);
        printArray(arr);
    }
    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0 ;
    }
    private static void swap(Comparable[] a,int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void swap(int[] a,int i, int j){
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void printArray(Comparable[] arr){
        System.out.println("----");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("----");
    }
    private static void printArray(int[] arr){
        System.out.println("----");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("----");
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi){
        for(int i=lo; i < hi;i++){
            if(less(a[i],a[i+1])) continue;else return false;
        }
        return true;
    }
    private static void knuthShuffle(Comparable[] arr){
        for(int i=0; i < arr.length;i++){
            swap(arr,i, StdRandom.uniform(i+1));
        }
    }

    public static void selectionSort(Comparable[] arr){
        for(int i=0;i< arr.length;i++){
            int min =i;
            for(int j=i;j<arr.length;j++){
                if(less(arr[j],arr[min])) min = j;
            }
            swap(arr,i,min);
        }
    }

    public static void insertionSort(Comparable[] arr){
        for(int i=0; i < arr.length ; i++){
            for(int j=i; j > 0; j--){
                if(less(arr[j],arr[j-1])){
                    swap(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    public static int bubbleSort(Comparable[] arr){
        int n = arr.length;
        int totalSwaps=0;
        for(int i=0; i < n; i++){
            int swapInOnePass =0;
            for(int j=0; j < n-1; j++){
                if(less(arr[j+1],arr[j])){
                    swap(arr,j,j+1);
                    swapInOnePass++;
                }
            }
            if(swapInOnePass==0){
                break;
            }else {
                totalSwaps+=swapInOnePass;
            }
        }
        return totalSwaps;
    }

    public static void bubbleSortTest(Comparable[] arr){
        System.out.println(MessageFormat.format("Array is sorted in {0} swaps",bubbleSort(arr)));
    }

    public static void selectionSortTest(Comparable[] arr){
        System.out.println("-----");
        System.out.println("Before knuth shuffle  - isSorted - "+ isSorted(arr,0,arr.length-1));
        System.out.println("KnuthShuffle");
        knuthShuffle(arr);
        printArray(arr);
        System.out.println("Before selection sort - isSorted - "+ isSorted(arr,0,arr.length-1));
        long t1=System.currentTimeMillis();
        selectionSort(arr);
        System.out.println("After selection sort - isSorted - "+ isSorted(arr,0,arr.length-1)
                + " : time -"+ (System.currentTimeMillis()-t1)+ " : for arr size ="+arr.length);
    }

    public static void insertionSortTest(Comparable[] arr){
        System.out.println("KnuthShuffle");
        knuthShuffle(arr);
        printArray(arr);
        System.out.println("Before insertion sort - isSorted - "+ isSorted(arr,0,arr.length-1));
        long t1=System.currentTimeMillis();
        insertionSort(arr);
        System.out.println("After insertion sort - isSorted - "+ isSorted(arr,0,arr.length-1)
                + " : time -"+ (System.currentTimeMillis()-t1)+ " : for arr size ="+arr.length);
    }
    public static void mergeSort(Comparable[] arr,Comparable[] aux, int lo, int hi){
        System.out.println("sort(arr,aux,"+lo+","+hi+")");
        if(hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        mergeSort(arr,aux,lo,mid);
        mergeSort(arr,aux,mid+1,hi);
        merge(arr,aux,lo,mid,hi);
    }

    private static void merge(Comparable[] arr,Comparable[] aux,int lo, int mid,int hi){
        //System.out.println("merge(arr,aux,"+lo+","+mid+","+hi+")");
        for(int i=0; i < arr.length ; i++){
            aux[i]=arr[i];
        }
        int i=lo,j=mid;
        for(int k=lo; k<hi;k++){
            if(i > mid){
                continue;
            }else if(j > hi){
                arr[k]=aux[i++];
            }else if(less(aux[j],aux[i])){
                arr[k]= aux[j++];
            }else{
                arr[k]=aux[i++];
            }
        }
    }


    public static void mergeSortTest(Comparable[] arr){
        Comparable[] aux = new Comparable[arr.length];
        mergeSort(arr,aux,0,arr.length-1);
    }

    public static void merge(Comparable[] arr,int lo,int mid,int hi){
        Comparable[] aux = new Comparable[arr.length];
        merge(arr,aux,lo,mid,hi);
    }
    public static void mergeSortBottomUp(Comparable[] arr){

        //increment i by doubling i
        for(int i=1;i<arr.length;i+=i){
            //j should be incremented by size of the sub array
                for(int j=0; j<arr.length-i;j+=i+i){
                    System.out.println("merge(arr,"+j+","+(j+i-1)+","+Math.min(j+i+i-1,arr.length-1)+")");
                    merge(arr,j,j+i-1,Math.min(j+i+i-1,arr.length-1));
                }
        }
    }

    public static void quickSort(Comparable[] arr,int lo, int hi){
        if(hi<=lo) return;
        int j = partition(arr,lo,hi);
        quickSort(arr,lo,j-1);
        quickSort(arr,j+1,hi);
    }

    private static int partition(Comparable[] arr,int lo,int hi){
        int i=lo,j=hi+1;
        while (true){
            while(less(arr[++i],arr[lo])){
                if(i==hi){
                    break;
                }
            }
            while(less(arr[lo],arr[--j])){
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
    public static void quickSortTest(Comparable[] arr){
        knuthShuffle(arr);
        printArray(arr);
        quickSort(arr,0,arr.length-1);
    }
    public static void heapSort(int[] arr){
        int count= arr.length;
        for(int i=count/2; i>=1;i--){
            sink(arr,i,count);
        }
        while(count>1){
            swap(arr,0,count-1);
            count--;
            sink(arr,1,count);
        }
    }

    private static void sink(int[] arr, int k,int count){
        while(2*k<=count){
            int i=2*k;
            if(i < count && arr[i]<arr[i-1]) i=i-1;
            if(arr[i-1]<arr[k-1]) break;
            swap(arr,i-1,k-1);
            k=i;
        }
    }
    private static void swim(int[] arr,int k,int count){
        while(k > 1 && arr[k-1]>arr[k/2-1]){
            swap(arr,k-1,k/2-1);
            k=k/2;
        }
    }

    public static void sortAStack(Stack<Integer> stack){
        Stack<Integer> sorted = new Stack<>();
        while(!stack.isEmpty()){
            int temp = stack.pop(); // hold the first element
            while(!sorted.isEmpty() && sorted.peek() > temp){
                stack.push(sorted.pop());
            }
            sorted.push(temp);
        }
        System.out.println("Sorted stack : ");
        for(int i : sorted){
            System.out.print(i+" ");
        }
    }

    public static int maxDiff(int arr[]){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i < arr.length ; i++){
            int elemValue = arr[i];
            if(elemValue < min){
                min = elemValue;
            }
            if(elemValue > max){
                max = elemValue;
            }
        }

        return max-min;
    }

}
