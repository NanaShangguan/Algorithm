package util;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nano on 2016/4/20.
 */
public class Graph {
    private final int V;
    private int E;
    private Set<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new HashSet[V];
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

    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges" + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) s.append(w + " ");
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
