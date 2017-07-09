package ctci;

import java.util.*;

/**
 * Created by Himadri Pal (mehimu@gmail.com) on 6/5/2017.
 */
public class Practice {

    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6,7,8,9};
        shuffle(arr);
        print(arr);
        insertionSort(arr);
        print(arr);
        shuffle(arr);
        print(arr);
        selectionSort(arr);
        print(arr);
        shuffle(arr);
        print(arr);
        int[] aux = new int[arr.length];
        mergeSort(arr,aux,0,arr.length-1);
        print(arr);
        shuffle(arr);
        print(arr);
        int[] arr1 = {2,9,6,1,8,3,4,7,5};
        quickSort(arr1,0,arr1.length-1);
        print(arr1);

        Graph g = new Graph(6);
        g.addEdge(1,3);
        g.addEdge(0,1);
        g.addEdge(2,3);
        g.addEdge(4,5);
        g.addEdge(2,4);

        g.bfs(g,0);
        System.out.println(g.getShortestPath(4,0));


    }

    private static void shuffle(int[] arr){
        Random r = new Random();
        for(int i=0; i< arr.length ; i++){
            swap(arr,i,r.nextInt(i+1));
        }
    }
    private static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }
    private static boolean less(int i, int j){
        if(i < j) return true;
        else if(i>j) return false;
        return true;
    }
    private static void print(int[] arr){
        System.out.println();
        for(int i:arr){
            System.out.print(i+",");
        }
        System.out.println();
    }

    private static void insertionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i; j > 0; j--){
                if(less(arr[j],arr[j-1])) swap(arr, j,j-1);
            }
        }
    }
    private static void selectionSort(int[] arr){
        for(int i=0; i< arr.length; i++){
            int min=i;
            for(int j=i+1; j <arr.length; j++ ){
                if(less(arr[j],arr[min])) min=j;
            }
            swap(arr,i,min);
        }
    }

    private static void mergeSort(int[] arr,int[] aux, int lo, int hi){
        if(lo >= hi) return;
        int mid = lo+(hi-lo)/2;
        mergeSort(arr,aux,lo,mid);
        mergeSort(arr,aux,mid+1,hi);
        merge(arr,aux,lo,mid,hi);
    }

    private static void merge(int[] arr,int[] aux,int lo,int mid,int hi){
        for(int i=0; i < arr.length ; i++){
            aux[i]=arr[i];
        }
       // print(aux);
        int i=lo,k=lo,j=mid+1;
        for(k=lo; k < arr.length; k++){
            if( i > mid){
                continue;
            }else if(j > hi ){
                arr[k]=aux[i++];
            }else if(less(aux[i],aux[j])){
                arr[k]=aux[i++];
            }else {
                arr[k]=aux[j++];
            }
        }
    }

    public static void quickSort(int[] arr, int lo,int hi){
        if(hi<=lo) return;
        int j= partition(arr,lo,hi);
        quickSort(arr,lo,j-1);
        quickSort(arr,j+1,hi);
    }

    private static int partition(int[] arr, int lo, int hi){
        int i=lo;
        int j=hi+1;
        while(true){
            while (arr[++i]<arr[lo]){
                if(i==hi) break;
            }
            while(arr[--j]> arr[lo]){
                if(j==lo) break;
            }
            if(i>=j) break;
            swap(arr,i,j);
        }
        swap(arr,lo,j);
        return j;
    }
    private class Node{
        int index;
        int data;
        public Node(int idx,int data){
            this.index=idx;
            this.data=data;
        }
    }

    private static class Graph{
        int V;
        int E;
        LinkedList<Integer>[] adjList=null;
        boolean marked[];
        int edgeTo[];
        public Graph(int size){
            marked = new boolean[size];
            edgeTo = new int[size];
            adjList = new LinkedList[size];
            for(int i=0 ; i < size; i++){
                adjList[i] = new LinkedList<Integer>();
            }
        }
        public void addEdge(int u,int v){
            adjList[u].add(v);
            adjList[v].add(u);
            E++;
        }
        public LinkedList<Integer> getAdjList(int v){
            return adjList[v];
        }
        private  boolean hasPathTo(int v){
            return marked[v];
        }

        private String getShortestPath(int v,int source){
            String paths = "";

            if(!hasPathTo(v)) return paths;
            for(int i=v; i!=source;i=edgeTo[i]){
                paths+=i+"->";
            }
            paths+=source;
            return paths;
        }

        public void bfs(Graph g, int startId){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(startId);
            while (!queue.isEmpty()){
                int node = queue.poll();
                marked[node]=true;
                for(int w : g.getAdjList(node))
                if(!marked[w]){
                    marked[w]=true;
                    edgeTo[w]=node;
                    queue.add(w);
                }
            }
        }
    }



}
