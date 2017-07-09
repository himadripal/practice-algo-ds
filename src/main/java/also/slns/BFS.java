package also.slns;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Breadth first search
 */
public class BFS {
    public static class Graph {
        int V;
        int E;
        int sourceId;
        int[] edgeTo;
        boolean[] marked;
        LinkedList<Integer>[] adjList = null;
        public Graph(int size) {
            this.V=size;
            this.E=0;
            edgeTo = new int[size];
            marked = new boolean[size];
            adjList = (LinkedList<Integer>[]) new LinkedList[size];
            for(int i=0; i < size ; i++){
                adjList[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int first, int second) {
            adjList[first].add(second);
            adjList[second].add(first);
            E++;
        }

        private  boolean hasPathTo(int v){
            return marked[v];
        }
        private  int pathTo(int v){
            if(!hasPathTo(v)) return -1;
            int totalPath = 0;
            for(int i=v; i!=sourceId ; i=edgeTo[i]){
                totalPath+=6;
            }
            return totalPath;
        }
        public int[] shortestReach(int startId) { // 0 indexed
            sourceId=startId;
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(startId);
            while(!queue.isEmpty()){
                int node = queue.poll();
                marked[node] = true;
                for(int adjNode : adjList[node]){
                    if(!marked[adjNode]){
                        edgeTo[adjNode] = node;
                        marked[adjNode] = true;
                        queue.add(adjNode);
                    }
                }
            }
            int[] paths = new int[V];
            for(int i=0; i < V; i++){
                //if(i==sourceId) continue;
                paths[i] = pathTo(i);
            }

            return paths;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }



}
