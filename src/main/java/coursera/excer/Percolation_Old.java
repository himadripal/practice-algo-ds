package coursera.excer;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

/* *
 * Created by hpal(mehimu@gmail.com) on 12/14/2016.
 */
public class Percolation_Old {
    private int[][] position  =  null;
    private WieghtedUnionQuickFind wieghtedUnionQuickFind  =  null;

    public Percolation_Old(int n)  {
        if  (n  <=   0) throw new IllegalArgumentException("n must be > = 0");
        wieghtedUnionQuickFind  =  new WieghtedUnionQuickFind(n*n+2);
        //  all n*n element + 2 virtual elements
        //  wieghtedUnionQuickFind.elem  =  new int[n*n+2]; 
        //  wieghtedUnionQuickFind.sizeArr  =  new int[n*n+2]; 
        //  add virtual elements as the last two elements in the array
        //  wieghtedUnionQuickFind.elem[0]  =  0; 
        //  another virtual element  =  total numbers +1
        //  wieghtedUnionQuickFind.elem[wieghtedUnionQuickFind.elem.length -1]  =  n*n+1; 
        position =  new int[n][n]; 
        int k = 1; 
        //  fill the position[][] and elem[] and sizeArr[]
         for (int i = 0;  i  < n;  i++) {
            for (int j = 0; j < n; j++) {
               position[i][j]  =  k; 
               k++; 
               // connect all elements in the top row to virtual element at 0
               if (i == 0) {
                   wieghtedUnionQuickFind.union(0, position[i][j]); 
               }
               // connect all bottom elements to virtual element at last
               if (i == n-1) {
                   wieghtedUnionQuickFind.union(n*n+1, position[i][j]); 
               }
           }

        }

    }

    /* *
     * Simply connect using Weighted Union method
     * @param p
     * @param q
     */
    /* private void union(int p,  int q) {
        int i  =  root(p); 
        int j  =  root(q); 
        if  (i =  = j) return; 
        if (sizeArr[i]  < =   sizeArr[j]) {
            elem[i]  =  j; 
            sizeArr[j]+ = sizeArr[i]; 
        }else {
            elem[j]  =  i; 
            sizeArr[i]+ = sizeArr[j]; 
        }
    }*/

    /* *
     * Connect with all 4 neighbours(left, right, above and below) if  exists and if  not connected
     * if  not connected is checked in union method.
     * @param i
     * @param j
     */
    public void open(int i,  int j) {
        int value  =  position[i][j]; 
        //  in the grid border cases it will throw exception so to
        //  indicate does not exists and will be set to -1
        int leftValue = getValue(i,  j-1);  //  left neighbour
        int rightValue = getValue(i,  j+1);  //  right neighbour
        int upValue  =  getValue(i-1,  j);  //  above neighbour
        int downValue  =  getValue(i+1,  j); //  below neighbour
        //  4 union call
        if (leftValue > 0)  {
            if(isOpen(i,j-1)) {
                wieghtedUnionQuickFind.union(value, leftValue); //  connect node with left neighbour if  exists
            }
        }
        if (rightValue > 0)  {
            if(isOpen(i,j+1)) {
                wieghtedUnionQuickFind.union(value, rightValue); //  connect node with right neighbour if  exists
            }
        }
        if (upValue > 0)  {
            if(isOpen(i-1,j)){
                wieghtedUnionQuickFind.union(value, upValue);  //  connect node with neighbour above if  exists
            }
        }
        if (downValue > 0) {
            if(isOpen(i+1,j)){
                wieghtedUnionQuickFind.union(value, downValue);  //  connect node with neighbour below if  exists
            }
        }
    }

    public boolean isOpen(int i, int j) {
        if(i > position.length -1 || j > position.length -1)  return false;
        int value  =  position[i][j]; 
        //  in the grid border cases it will throw exception so to
        //  indicate does not exists and will be set to -1
        int leftValue  =  getValue(i, j-1);  //  left neighbour
        int rightValue  =  getValue(i, j+1);  //  right neighbour
        int upValue  =  getValue(i-1, j);  //  above neighbour
        int downValue  =  getValue(i+1, j); //  below neighbour
        //  4 connected call
        boolean leftConnected  =  false; 
        boolean rightConnected  =  false; 
        boolean upConnected = false;
        boolean downConnected = false;

        if (leftValue >= 0)  {
            leftConnected  =  wieghtedUnionQuickFind.connected(value, leftValue); 
        }
        if (rightValue >= 0) {
            rightConnected  =  wieghtedUnionQuickFind.connected(value, rightValue); 
        }

        if (upValue >= 0) {
            if (i == 0)  {
                upConnected  =  true; 
            } else  {
                upConnected  =  wieghtedUnionQuickFind.connected(value,  upValue); 
            }
        }
        if (downValue >= 0) {
            if (i == position.length-1) {
                downConnected  =  true; 
            } else  {
                downConnected  =  wieghtedUnionQuickFind.connected(value,  downValue); 
            }
        }
        if(i == 0 && j == 0){
            return rightConnected || downConnected;
        }
        if (j == 0 ) return (rightConnected || upConnected || downConnected);
        if (j == position.length -1) return (leftConnected || upConnected || downConnected);
        if (i == 0) return (rightConnected || leftConnected  || downConnected);
        if (i == position.length -1) return (leftConnected || rightConnected || upConnected);


        // return true if  any of them are connected.
        return (rightConnected || leftConnected || upConnected || downConnected);
    }

    public boolean isFull(int i,  int j) {
       return wieghtedUnionQuickFind.connected(0,position[i][j]);
    }

    /* *
     * Get the neighbour value if  exists otherwise return -1
     * @param i
     * @param j
     * @return
     */
    private int getValue(int i,  int j) {
        int value; 
        try  {
            value  =  position[i][j]; 
        } catch (ArrayIndexOutOfBoundsException e) {
            value  =  -1; 
        }
        return value; 
    }

    /* *
     * Check if  the 2 virtual nodes are connected
     * @return
     */
    public boolean percolates() {

        return wieghtedUnionQuickFind.connected(0, position.length*position.length+1); 
    }



       public static void main(String[] args) {
        int n  =  200;
        Percolation_Old p  =  new Percolation_Old(n);
        int i =  0; 
        int j = 0; 
        System.out.println("i = "+i+", j = "+j); 
        int numOfOpen  =  0; 
        while (!p.percolates()) {
            // generate random i and j
            i = ThreadLocalRandom.current().nextInt(0,n-1);
            j = ThreadLocalRandom.current().nextInt(0,n-1);
            if (p.isFull(i, j))  {
                p.open(i, j);
                numOfOpen++;

            }
        }
        double percolationThresold  =  (numOfOpen+2*n)/(n*n+2.0);
        System.out.println("no of open - "+ (numOfOpen+n+n)); 
        System.out.print(String.format("%.5f",  percolationThresold));

    }

    /**
     * Created by 371865 on 12/14/2016.
     */
    public static class WieghtedUnionQuickFind {
        private int[] elem = null;
        private int[] sizeArr;
        private int openSite;

        public WieghtedUnionQuickFind(int n){

            elem = new int[n];
            for(int i=0;i <n; i++){
                elem[i] = i;
            }
            sizeArr = new int[n];
            for(int i=0;i <n; i++){
                sizeArr[i] = 1;
            }
        }

        public void union(int p, int q){
            int i = root(p);
            int j = root(q);
            if (i==j) return;
            if(sizeArr[i] <= sizeArr[j]){
                elem[i] = j;
                sizeArr[j]+=sizeArr[i];
                sizeArr[i] = 1;
            }else{
                elem[j] = i;
                sizeArr[i]+=sizeArr[j];
                sizeArr[j]=1;
            }
        }
        public boolean connected(int p,int q){
           return root(p)==root(q);
        }

        public int root(int i){
            while(i != elem[i]){
              i=elem[i];
            }
            return i;
        }


        public static void main(String[] args) throws  Exception{
            WieghtedUnionQuickFind wuqf = new WieghtedUnionQuickFind(20);
           // WeightedQuickUnionUF wuqf = new WeightedQuickUnionUF(7);
            //10
           // 1 17
           // 5 13
            //7 12
            //5 17
            //5 12
            //2 17
            //1 18
            //8 13
            //2 15
            //5 20
            //System.out.println(wuqf.connected(5,2));
           /* wuqf.union(1-1,17-1); //0,16
            wuqf.union(5-1,13-1); //4,12
            wuqf.union(7-1,12-1); //6,11
            wuqf.union(5-1,17-1); //4,16
            wuqf.union(5-1,12-1); //4,11
            wuqf.union(2-1,17-1); //1,16
            wuqf.union(1-1,18-1); //0,17
            wuqf.union(8-1,13-1); //7,12
            wuqf.union(2-1,15-1); //1,14
            wuqf.union(5-1,20-1); //4,19
            //wuqf.union(2,17);*/

          // File f = new File("/input1.txt");
            URI uri = wuqf.getClass().getResource("/input1.txt").toURI();
            for (String s : Files.readAllLines( Paths.get(uri))){
                String[] elems = s.split(" ");
                int n=0;
                if (elems.length == 1){
                    n = Integer.valueOf(elems[0]);
                }
                for(int i=0; i < n; i++){
                    int elem1 = Integer.valueOf(s.split(" ")[0]) -1 ;
                    int elem2 = Integer.valueOf(s.split(" ")[1]) -1 ;
                    wuqf.union(elem1,elem2);
                }
            }



            //System.out.println(wuqf.connected(5,2));
            //System.out.println(wuqf.connected(1,3));

            int max=0;
            int min=wuqf.sizeArr.length;

            for(int i = 0; i < wuqf.sizeArr.length ; i++){
                int size = wuqf.sizeArr[i];
                if(size ==1){
                    continue;
                }
                if(size > max){
                    max = size;
                }
                if(size < min){
                    min = size;
                }
            }

            System.out.println(min);
            System.out.println(max);

        }
    }

    /**
     * Created by 371865 on 12/14/2016.
     */
    public static class WieghtedUnionQuickFindnNode {
        public class Node{
            int data;
            int indexPosition;
            public Node(int n){
                data = n;
                indexPosition = n-1;
            }
        }
        private Node[] elem = null;
        private int[] sizeArr;

        public WieghtedUnionQuickFindnNode(int n){

            elem = new Node[n];
            for(int i=0;i <n; i++){
                Node node = new Node(i+1);
                elem[i] = node;
            }
            sizeArr = new int[n];
            for(int i=0;i <n; i++){
                sizeArr[i] = 1;
            }
        }

        public void union(int p, int q){
            int i = root(p);
            int j = root(q);
            if (i==j) return;
            if(sizeArr[i] <= sizeArr[j]){
                elem[i].data = j;
                sizeArr[j]+=sizeArr[i];
            }else{
                elem[j].data = i;
                sizeArr[i]+=sizeArr[j];
            }
        }
        public boolean connected(int p,int q){
           return root(p)==root(q);
        }

        public int root(int i){
            while(i != elem[i].data){
              i=elem[i].data;
            }
            return i;
        }


        public static void main(String[] args){
            WieghtedUnionQuickFindnNode wuqf = new WieghtedUnionQuickFindnNode(7);
           // WeightedQuickUnionUF wuqf = new WeightedQuickUnionUF(7);
            System.out.println(wuqf.connected(5,2));
            wuqf.union(5,2);
            wuqf.union(3,5);
            wuqf.union(6,0);
            wuqf.union(6,4);
            wuqf.union(6,1);
            wuqf.union(3,0);

            System.out.println(wuqf.connected(5,2));
            System.out.println(wuqf.connected(1,3));

            int max=0;
            int min=0;

            for(int i = 0; i < wuqf.sizeArr.length ; i++){
                int size = wuqf.sizeArr[i];
                if(size > max){
                    max = size;
                }
                if(size < min){
                    min = size;
                }
            }
            System.out.println(min);
            System.out.println(max);

        }
    }
}
