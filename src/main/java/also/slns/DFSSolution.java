package also.slns;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Depth First Search with Graph
 */


public class DFSSolution {
    public static class Graph{
        int V;
        int E;
        LinkedList<Integer>[] adjList;
        Graph(int size){
            this.V=size;
            this.E=0;
            adjList= (LinkedList<Integer>[])new LinkedList[size];
            for(int i=0; i < V; i++){
                adjList[i]=new LinkedList<Integer>();
            }
        }
        public void addEdge(int u, int v){
           adjList[u].add(v);
           adjList[v].add(u);
        }
        public LinkedList<Integer> getAdjList(int v){
            return adjList[v];
        }
    }

    static boolean[] seen =null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Graph g = new Graph(n);
        seen = new boolean[n];
        for(int i=0; i < n-1 ; i++){
            g.addEdge(in.nextInt()-1, in.nextInt()-1);
        }
        Set<String> pairs = new TreeSet<>();
        System.out.println(dfs(g,k,0,0,pairs));

        for(String s : pairs) {
            System.out.println(s);
        }

    }

    private static int dfs(Graph g, int k,int v,int pairs,Set<String> pairsSet){
        seen[v]=true;
        //int result = pairs;
        for(int w:g.getAdjList(v)){
            if(!seen[w]){
                if(Math.abs(w-v) <= k){
                   pairsSet.add(v+","+w);
                    pairs++;
                }
                pairs = dfs(g,k,w,pairs,pairsSet);
            }else{
                if(Math.abs(w-v) <= k){

                        pairs++;
                        pairsSet.add(v + "," + w);

                }
            }
        }
        return pairs;
    }
}