package ctci;

import edu.princeton.cs.algs4.In;

import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by 371865 on 3/20/2017.
 */
public class Q9_2_MazePath {

    public static int size = 4;
    public static int[][] maze = new int[size][size];

    public static boolean isFree(int x, int y) {
        if (maze[x][y] == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean getPath(int x, int y, ArrayList<Point> path) {
        // If out of bounds or not available, return.
        if (y < 0 || x < 0 || !isFree(x, y)) {
            return false;
        }

        boolean isAtOrigin = (x == 0) && (y == 0);

        // If there's a path from the start to my current location, add my location.
        if (isAtOrigin || getPath(x, y - 1, path) || getPath(x - 1, y, path)) {
            Point p = new Point(x, y);
            path.add(p);
            return true;
        }

        return false;
    }

    public static boolean getPath(int x, int y, ArrayList<Point> path, Hashtable<Point, Boolean> cache) {
		/* If out of bounds or not available, return.*/
        if (y < 0 || x < 0 || !isFree(x, y)) {
            return false;
        }
        Point p = new Point(x, y);

		/* If we've already visited this cell, return. */
        if (cache.containsKey(p)) {
            return cache.get(p);
        }

        boolean isAtOrigin = (x == 0) && (y == 0);
        boolean success = false;

		/* If there's a path from the start to my current location, add my location.*/
        if (isAtOrigin || getPath(x, y - 1, path, cache) || getPath(x - 1, y, path, cache)) {
            path.add(p);
            success = true;
        }

        cache.put(p, success); // Cache result
        return success;
    }

    private static int getAllPaths(int[][] matrix, int i, int j, String path, int cost,ArrayList<String> paths,int minCost){
        if( i <= matrix.length-1 && j <= matrix[0].length-1) {
            cost = cost + matrix[i][j];
            path = path + "->" + matrix[i][j];
            if (i == matrix.length - 1 && j == matrix[0].length - 1) {
                if (cost < minCost) {
                    minCost = cost;
                }
                paths.add(path+"="+cost);

            } else {
                minCost = getAllPaths(matrix, i + 1, j, path, cost, paths, minCost);
                minCost = getAllPaths(matrix, i, j + 1, path, cost, paths, minCost);
            }
        }else {
           return minCost;
        }
        return minCost;
    }

    private static int miniCostPath(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        //fill up first row
        int[][] cost = new int[m+1][n+1];
        cost[0][0]=grid[0][0];
        for(int j=1; j < n ; j++){
            cost[0][j]=cost[0][j-1]+grid[0][j];
        }
        for(int i=1; i<m;i++){
            cost[i][0] = cost[i-1][0]+grid[i][0];
        }
        for(int i=1; i < m; i++){
            for(int j=1; j < n; j++){
                cost[i][j]= grid[i][j] + Math.min(cost[i-1][j],cost[i][j-1]);
            }
        }
        return cost[m-1][n-1];
    }

    public static void main(String[] args) {
        maze = AssortedMethods.randomMatrix(4, 4, 1, 2);
        AssortedMethods.printMatrix(maze);
        ArrayList<Point> path = new ArrayList<Point>();
        Hashtable<Point, Boolean> cache = new Hashtable<Point, Boolean>();
        boolean success = getPath(size - 1, size - 1, path, cache);

        if (success) {
            String s = AssortedMethods.listOfPointsToString(path);
            System.out.println("Path: " + " " + s);
        } else {
            System.out.println("No path exists.");
        }
        String pathSingle = "";
        ArrayList<String> paths = new ArrayList<>();
        Integer miniCost = new Integer(Integer.MAX_VALUE);
        int minCost = getAllPaths(maze,0,0,pathSingle,0,paths,miniCost);
        System.out.println("minCost - "+minCost);
        System.out.println();
        System.out.println("path size - "+paths.size());
        for(String s : paths){
            System.out.println(s);
        }
        System.out.println(miniCostPath(maze));
    }


}

