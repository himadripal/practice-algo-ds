package also.slns;

import java.util.*;

/**
 * author - hpal(mehimu@gmail.com)
 * Find biggest region and number of islands- both dfs and bfs
 */
public class ConnectedCompFromMatrix {
    private static Map<Integer,Integer> componentCount = new HashMap<Integer,Integer>();
    private static boolean[] seen = null;
    private static int regions;

    private static int[] ids;

   private static boolean isTraverable(int[][] grid, int i,int j){
        if((i > grid.length-1 || i<0 )||(j>grid[0].length-1 || j<0)){
            return false;
        }
        return grid[i][j]==1?true:false;
    }
    private static int getVertex(int i,int j,int rowSize){
        return i*rowSize+j;
    }

    public static int getBiggestRegion(int[][] grid) {
        int m= grid[0].length;
        int n= grid.length;
        Graph G = new Graph(m*n-1);
        for(int i=0; i < n; i++)
            for(int j=0; j < m;j++){
            if(isTraverable(grid,i,j)) {
                int point = i*m+j;
              //  int rightPoint = ; //grid_i*m+(grid_j+1
                if(isTraverable(grid,i,j+1)) {
                   G.addEdge(point, getVertex(i,j+1,m));
                }
                //below
                if(isTraverable(grid,i+1,j)){
                    G.addEdge(point, getVertex(i+1,j,m));
                }
                //digonally below left
                if(isTraverable(grid,i+1,j-1)){
                    G.addEdge(point,getVertex(i+1,j-1,m));
                }
                //digonally right below
                if(isTraverable(grid,i+1,j+1)){
                    G.addEdge(point,getVertex(i+1,j+1,m));
                }
            }
        }
        seen = new boolean[m*n-1];
        ids = new int[m*n -1];
        for(int s=0; s <G.V(); s++){
            if(!seen[s]) {
                dfsG(G,s);
                regions++;
            }
        }

        int max = 0;
        for(Integer value : componentCount.values()){
            if(value > max) max = value;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        //int m = in.nextInt();

        int grid[][] =  {{1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}};
        int root = 0;
       /* for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();

            }
        }
*/
        System.out.println(bfsMatrix(grid));
    }

    private static void dfsG(Graph G, int v){
        seen[v] = true;
        ids[v] = regions;
        Integer count = componentCount.get(regions);
        if(count ==null){
            count=0;
        }
        componentCount.put(regions,++count);
        for(int w : G.adj(v)){
            if(!seen[w]) dfsG(G,w);
        }

    }

    private static int bfsMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int noOfIsland=0;
        HashMap<Integer,Integer> islandCounter = new HashMap<>();
        int isLandNbr=0;
        for(int i=0; i <m; i++){
            for(int j=0; j < n; j++){
                if(matrix[i][j]==1){
                    isLandNbr++;
                   // int countOfLands = markAllInIsland(matrix,i,j,isLandNbr);
                    int countOfLands = markAllIslandDFS(matrix,i,j,0);
                    islandCounter.put(isLandNbr,countOfLands);
                }
            }
        }
        int maxCellCount =0;
        System.out.println(" no of island - "+(isLandNbr));
        for(int i : islandCounter.keySet()){
            if(islandCounter.get(i) > maxCellCount){
                maxCellCount = islandCounter.get(i);
            }
        }
        System.out.println(maxCellCount);
        return maxCellCount;
    }
    static class Index{
        int row;
        int column;
        public Index(int row, int column){
            this.row = row;
            this.column = column;
        }

    }
    private  static int markAllInIsland(int[][] matrix,int i, int j,int isLandNo){
        Queue<Index> queue = new LinkedList<>();
        queue.add(new Index(i, j));
        int count=0;
        while(!queue.isEmpty()){
            Index idx = queue.poll();
            if(matrix[idx.row][idx.column] ==1){
                count++;
                matrix[idx.row][idx.column] = -1;
                //right point
                if(isTraverable(matrix,idx.row,idx.column+1)) queue.add(new Index(idx.row,idx.column+1));
                //right corner down
                if(isTraverable(matrix,idx.row+1,idx.column+1)) queue.add(new Index(idx.row+1,idx.column+1));
                //just below
                if(isTraverable(matrix,idx.row+1,idx.column)) queue.add(new Index(idx.row+1,idx.column));
                //left  down corner
                if(isTraverable(matrix,idx.row+1,idx.column-1)) queue.add(new Index(idx.row+1,idx.column-1));
                //left
                if(isTraverable(matrix,idx.row,idx.column-1)) queue.add(new Index(idx.row,idx.column-1));
                //top left
                if(isTraverable(matrix,idx.row-1,idx.column-1)) queue.add(new Index(idx.row-1,idx.column-1));
                //top
                if(isTraverable(matrix,idx.row-1,idx.column)) queue.add(new Index(idx.row-1,idx.column));
                //top right
                if(isTraverable(matrix,idx.row-1,idx.column+1)) queue.add(new Index(idx.row-1,idx.column+1));
            }
        }
        return count;
    }

    private static int markAllIslandDFS(int[][] matrix,int i,int j,int count){


        if(matrix[i][j]==1) {
            matrix[i][j]=-1;
            count++;

        if(isTraverable(matrix,i,j+1)) {
            return markAllIslandDFS(matrix,i,j+1,count);
        }
        //right corner down
        if(isTraverable(matrix,i+1,j+1)){
            return markAllIslandDFS(matrix,i+1,j+1,count);
        }
        //just below
        if(isTraverable(matrix,i+1,j)) {
            return markAllIslandDFS(matrix,i+1,j,count);
        }
        //left  down corner
        if(isTraverable(matrix,i+1,j-1)) {
           return markAllIslandDFS(matrix,i+1,j-1,count);
        }
        //left
        if(isTraverable(matrix,i,j-1)) {
            return markAllIslandDFS(matrix,i,j-1,count);
        }
        //top left
        if(isTraverable(matrix,i-1,j-1)){
            return markAllIslandDFS(matrix,i-1,j-1,count);
        }
        //top
        if(isTraverable(matrix,i-1,j)) {
            return markAllIslandDFS(matrix,i-1,j,count);
         }
         if(isTraverable(matrix,i-1,j+1)) {
                return markAllIslandDFS(matrix,i-1,j+1,count);
         }
        }
        return count;
    }


}
