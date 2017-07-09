package also.slns;

import java.util.LinkedList;

/**
 * Created by 371865 on 3/6/2017.
 */
public class Graph {
    private int V;
    private int E;
    private LinkedList<Integer>[] adjList ;
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public Graph(int v){
        this.V = v;
        this.E = 0;
        adjList = (LinkedList<Integer>[])new LinkedList[v];
        for(int i=0; i < v; i++){
            adjList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int v, int w){
        adjList[v].add(w);
        adjList[w].add(v);
    }
    public Iterable<Integer> adj(int v){
        return adjList[v];
    }


}
