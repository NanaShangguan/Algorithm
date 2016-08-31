package lintcode;

import util.DirectedGraphNode;

import java.util.*;

/**
 * Created by t-nashan on 8/31/2016.
 */
public class TopologicalSorting {
    static class Vertex {
        DirectedGraphNode node;
        int inDegree;
        public Vertex(DirectedGraphNode node, int in) {
            this.node = node;
            this.inDegree = in;
        }
    }

    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        PriorityQueue<Vertex> heap = new PriorityQueue<>(10, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return Integer.compare(o1.inDegree, o2.inDegree);
            }
        });
        HashMap<DirectedGraphNode, Vertex> map = new HashMap<>();
        for (DirectedGraphNode node : graph) map.put(node, new Vertex(node, 0));
        for (DirectedGraphNode node : graph) {
            ArrayList<DirectedGraphNode> neighbors = node.neighbors;
            for (DirectedGraphNode n : neighbors) {
                map.get(n).inDegree++;
            }
        }
        for (Vertex v : map.values()) heap.add(v);
        ArrayList<DirectedGraphNode> sorted = new ArrayList<>();
        while (!heap.isEmpty()) {
            Vertex min = heap.poll();
            sorted.add(min.node);
            ArrayList<DirectedGraphNode> neighbors = min.node.neighbors;
            for (DirectedGraphNode n : neighbors) {
                map.get(n).inDegree--;
                heap.remove(map.get(n));
                heap.add(map.get(n));
            }
        }
        return sorted;
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
