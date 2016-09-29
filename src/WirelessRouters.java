import java.io.PrintStream;
import java.util.*;

/**
 * Created by Nano on 2016/9/29.
 */
public class WirelessRouters {
    static class Graph {
        private final int V;
        private int E;
        private Set<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            adj = new HashSet[V];
            for (int i = 0; i < V; i++) adj[i] = new HashSet<>();
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

    static class GraphNode {
        int v;
        int satis;
        public GraphNode(int v, int satis) {
            this.v = v;
            this.satis = satis;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int N = in.nextInt(), M = in.nextInt();
        int[] satisfaction = new int[N];
        for (int i = 0; i < N; i++) satisfaction[i] = in.nextInt();

        //M >= N
        if (M >= N) {
            int sum = 0;
            for (int satis : satisfaction) sum += satis;
            out.println(sum);
            return;
        }
        //M < N
        Graph graph = new Graph(N);
        for (int i = 0; i < N - 1; i++) {
            int v = in.nextInt() - 1, w = in.nextInt() - 1;
            graph.addEdge(v, w);
        }
        Set<GraphNode> set = new HashSet<>();
        int satisCount = 0;
        //init
        GraphNode max = null;
        for (int i = 0; i < N; i++) {
            Iterator<Integer> it = graph.adj(i).iterator();
            int sum = satisfaction[i];
            while (it.hasNext()) {
                sum += satisfaction[it.next()];
            }
            GraphNode node = new GraphNode(i, sum);
            if (max == null || max.satis < node.satis) max = node;
            set.add(node);
        }
        boolean[] isDead = new boolean[N];
        //place wireless routers
        while (!set.isEmpty() && M > 0) {
            M--;
            set.remove(max);
            isDead[max.v] = true;
            satisCount += max.satis;
            Iterator<Integer> it = graph.adj(max.v).iterator();
            while (it.hasNext()) {
                int adj = it.next();
                //reset
                satisfaction[adj] = 0;
            }
            max = null;
            Iterator<GraphNode> iterator = set.iterator();
            while (iterator.hasNext()) {
                GraphNode cur = iterator.next();
                it = graph.adj(cur.v).iterator();
                int sum = satisfaction[cur.v];
                while (it.hasNext()) {
                    int adj = it.next();
                    if (!isDead[adj]) sum += satisfaction[adj];
                }
                cur.satis = sum;
                if (max == null || max.satis < cur.satis) max = cur;
            }
        }
        out.println(satisCount);
    }
}
