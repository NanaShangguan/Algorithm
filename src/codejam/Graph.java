package codejam;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nano on 2016/6/14.
 * algs4 version
 */
public class Graph {
    private final int V;
    private int E;
    private Set<Integer>[] adj;
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Set[V];
        for (int v = 0; v < V; v++)
            adj[v] = new HashSet<Integer>();
    }
    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
