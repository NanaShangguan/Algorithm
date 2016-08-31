package lintcode;

import util.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by t-nashan on 8/31/2016.
 */
public class TopologicalSorting {

    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> sorted = new ArrayList<DirectedGraphNode>();
        int len = graph.size();
        HashSet<DirectedGraphNode> visited = new HashSet<>();
        int from = 0;
        for (int j = 0; j < len; j++) {
            if (!visited.contains(graph.get(j))) {
                sorted.add(graph.get(j));
                visited.add(graph.get(j));
                for (int i = from; i < sorted.size(); i++) {
                    DirectedGraphNode cur = sorted.get(i);
                    ArrayList<DirectedGraphNode> neighbors = cur.neighbors;
                    for (DirectedGraphNode node : neighbors)
                        if (visited.contains(node)) sorted.remove(node);
                    for (DirectedGraphNode node : neighbors)
                        if (visited.contains(node)) sorted.add(node);
                    for (DirectedGraphNode node : neighbors)
                        if (!visited.contains(node)) {
                            sorted.add(node);
                            visited.add(node);
                        }
                    i = sorted.indexOf(cur);
                }
                from = sorted.size();
            }
        }
        return sorted;
    }

    private void dfs(DirectedGraphNode node, int depth, HashSet<DirectedGraphNode> visited, ) {
        if (visited.contains(node)) return;
    }

    public static void main(String[] args) {
        DirectedGraphNode n0 = new DirectedGraphNode(0);
        DirectedGraphNode n1 = new DirectedGraphNode(1);
        DirectedGraphNode n2 = new DirectedGraphNode(2);
        DirectedGraphNode n3 = new DirectedGraphNode(3);
        DirectedGraphNode n4 = new DirectedGraphNode(4);
        n0.neighbors.add(n1); n0.neighbors.add(n3);
        n2.neighbors.add(n0); n2.neighbors.add(n1); n2.neighbors.add(n3); n2.neighbors.add(n4);
        n3.neighbors.add(n1);
        n4.neighbors.add(n0); n4.neighbors.add(n1); n4.neighbors.add(n3);
        ArrayList<DirectedGraphNode> graph = new ArrayList<>();
        graph.add(n0);graph.add(n1);graph.add(n2);graph.add(n3);graph.add(n4);
        System.out.println(new TopologicalSorting().topSort(graph));
    }
}
